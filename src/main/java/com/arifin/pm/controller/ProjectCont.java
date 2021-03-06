package com.arifin.pm.controller;

import com.arifin.helper.MappingCore;
import com.arifin.pm.dao.GrafikDao;
import com.arifin.pm.dao.project.ProjectDao;
import com.arifin.pm.model.Project;
import com.arifin.pm.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * Created by ojiepermana on 11/10/2016.
 */
@Controller
@RestController
@RequestMapping("/pm/project")
public class ProjectCont {
    private final Logger LOG = LoggerFactory.getLogger(PerusahaanCont.class);

    @Autowired
    ProjectDao projectDao;
    @Autowired
    GrafikDao grafikDao;

    @Autowired
    ProjectService projectService;


    @GetMapping("")
    public ResponseEntity<MappingCore> getProjectFilter(@RequestParam Map<String,String> param)
    {

        List TOTAL = projectDao.getAll(param,false);
        List datas = projectDao.getAll(param,true);
        MappingCore obj = new MappingCore();

        obj.setDatas(datas);
        obj.setJumlah(datas.size());
        obj.setTotal(TOTAL.size());
        obj.setParam(param);

        return new ResponseEntity<MappingCore>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> detailProject(@PathVariable("id") Integer id_project)
    {
        Object project = projectDao.detail(id_project);
        if(project !=null)
        {
            return new ResponseEntity (project, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity ("Project Tidak ditemukan", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value = "/serapan/{id}")
    public ResponseEntity<?> serapan_anggaran(@PathVariable("id") Integer id_project)
    {
        Object project = projectDao.getReportSerapanAnggaranTask(id_project);
        if(project !=null)
        {
            return new ResponseEntity (project, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity ("Project Tidak ditemukan", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/detail_lite/{id}")
    public ResponseEntity<?> detailProjectLite(@PathVariable("id") Integer id_project)
    {
        Project project = projectDao.detailLite(id_project);
        if(project !=null)
        {
            return new ResponseEntity (project, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity ("Project Tidak ditemukan", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


//    @RequestBody -> string, map, bisa hashmap / @
    @PostMapping(value = "/add")
    public ResponseEntity saveProject(@RequestBody Project json)
    {
        if(!projectDao.create(json))
        {
            return new ResponseEntity ("error", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity (json, HttpStatus.CREATED);
    }
    @PostMapping(value = "/edit/{id_project}")
    public ResponseEntity editProject(@PathVariable int id_project, @RequestBody Project json)
    {
        Project projectCheck = projectDao.detailLite(id_project);
        if(projectCheck.getIs_lock() > 0)
        {
            return new ResponseEntity ("error, tidak ada aksess", HttpStatus.NO_CONTENT);
        }

        if(!projectDao.update(id_project, json))
        {
            return new ResponseEntity ("error", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity (json, HttpStatus.CREATED);
    }
    
    
    //GRAFIK
    @GetMapping("/grafik/timeline/{id_project}")
    public ResponseEntity getTimeline(@PathVariable int id_project)
    {
        Object timelie = projectService.getTimelineHarian(id_project);

        return ResponseEntity.ok(timelie);
    }

    @GetMapping("/grafik/kurva/{id_project}")
    public ResponseEntity getKurvaS(@PathVariable int id_project)
    {
        Object kurva = projectService.getKurvas(id_project);
        return ResponseEntity.ok(kurva);
    }




}
