package com.arifin.pm.controller;

import com.arifin.pm.dao.project.Project_cairDao;
import com.arifin.pm.model.Project_cair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by etos on 11/28/2016.
 */
@RestController
@RequestMapping(value = "/pm/project/cair")
public class Project_cairCont {

    @Autowired
    Project_cairDao projectCairDao;

    @GetMapping("/{id_project}")
    public ResponseEntity getAll(@PathVariable int id_project)
    {
        List<Project_cair> cairList = projectCairDao.getAll(id_project);
        return ResponseEntity.ok(cairList);
    }

    @GetMapping("/pre_add/{id_project}")
    public ResponseEntity getPreAdd(@PathVariable int id_project)
    {
        Object  cair = projectCairDao.getPreAdd(id_project);
        if(cair != null)
        {
            return new ResponseEntity(cair, HttpStatus.OK);
        }
        return new ResponseEntity("tidak ditemukan",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/detail/{id_cair}")
    public ResponseEntity getDetail(@PathVariable int id_cair)
    {
        Project_cair  cair = projectCairDao.getDetail(id_cair);
        if(cair != null)
        {
            return new ResponseEntity(cair, HttpStatus.OK);
        }
        return new ResponseEntity("tidak ditemukan",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Project_cair cair)
    {
        projectCairDao.add(cair);
        return ResponseEntity.ok(cair);
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody Project_cair cair)
    {
        projectCairDao.edit(cair);
        return ResponseEntity.ok(cair);
    }
}
