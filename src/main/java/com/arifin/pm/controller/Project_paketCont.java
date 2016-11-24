package com.arifin.pm.controller;

import com.arifin.pm.dao.project.Project_paketDao;
import com.arifin.pm.model.Project_paket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
@RestController
@RequestMapping(value = "/pm/project")
public class Project_paketCont {
    private final Logger LOG = LoggerFactory.getLogger(Project_paketCont.class);

    @Autowired
    private Project_paketDao project_paketDao;

    @GetMapping("/paket")
    public ResponseEntity getData(@RequestParam Map<String,String> param) {

        List datas = project_paketDao.getList(param);

        return new ResponseEntity(datas, HttpStatus.OK);
    }

    @GetMapping("/paket/{id_project_paket}")
    public ResponseEntity getDetail(@PathVariable("id_project_paket") int id_project_paket)
    {
        Object data = project_paketDao.getDetail(id_project_paket);
        if(data != null)
        {
            return new ResponseEntity(data,HttpStatus.OK);
        }

        return new ResponseEntity ("Paket TIdak Di temukan",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/paket_lite/{id_project_paket}")
    public ResponseEntity getDetailLite(@PathVariable("id_project_paket") int id_project_paket)
    {
        Project_paket data = project_paketDao.getDetailLite(id_project_paket);
        return new ResponseEntity(data,HttpStatus.OK);

    }


    @PostMapping("/paket/add")
    public ResponseEntity addPaket(@RequestBody Project_paket project_paket)
    {
        if(project_paketDao.add(project_paket))
        {
            return new ResponseEntity(project_paket,HttpStatus.OK);
        }
        return new ResponseEntity("gagal input",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/paket/edit")
    public ResponseEntity editPaket(@RequestBody Project_paket project_paket)
    {
        if(project_paketDao.edit(project_paket))
        {
            return new ResponseEntity(project_paket,HttpStatus.OK);
        }
        return new ResponseEntity("gagal input",HttpStatus.BAD_REQUEST);
    }

}
