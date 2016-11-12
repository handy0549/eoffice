package com.arifin.pm.controller;

import com.arifin.helper.MappingCore;
import com.arifin.pm.dao.ProjectDao;
import com.arifin.pm.model.Project;
import com.arifin.pm.model.Project_jenis;
import org.json.JSONObject;
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
public class ProjectCont {
    private final Logger LOG = LoggerFactory.getLogger(PerusahaanCont.class);

    @Autowired
    ProjectDao projectDao;


    @GetMapping("/pm/project")
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

    @GetMapping(value = "/pm/project/{id}")
    public ResponseEntity<String> detailProject(@PathVariable Integer id_project)
    {
        String param = "ASd" + id_project;
        return new ResponseEntity<String>(param, HttpStatus.OK);
    }



    @GetMapping(value = "/pm/project/add")
    public ResponseEntity<String> addProject(@RequestParam Map<String,String> json)
    {
        System.out.print("ss"  + json.get("jumlah"));
        String param = "ASd";
        return new ResponseEntity<String>(param, HttpStatus.OK);
    }

//    @RequestBody -> string, map, bisa hashmap / @
    @PostMapping(value = "/pm/project/add")
    public ResponseEntity saveProject(@RequestBody Project json)
    {
        if(!projectDao.create(json))
        {
            return new ResponseEntity ("error", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity (json, HttpStatus.CREATED);
    }

    public ResponseEntity<String> editProject(@RequestBody Map<String,String> json)
    {
//        System.out.print("ss"  + json.get("jumlah") + json.size());
        String param = "ASd" + json;
        return new ResponseEntity<String>(param, HttpStatus.OK);
    }


}
