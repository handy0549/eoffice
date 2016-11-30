package com.arifin.pm.controller;

import com.arifin.pm.dao.project.ModulDao;
import com.arifin.pm.model.Modul;
import com.arifin.pm.service.ModuleService;
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
 * Created by Handy on 08/11/2016.
 */

@RestController
@RequestMapping(value = "/pm/project/modul")
public class ModulCont {
    private final Logger LOG = LoggerFactory.getLogger(ModulCont.class);

    @Autowired
    private ModulDao modulDao;
    @Autowired
    ModuleService moduleService;

    @GetMapping("/{id_project}")
    public ResponseEntity getData(@PathVariable int id_project) {

        List datas = moduleService.getAllModul(id_project);
        return new ResponseEntity<List<Modul>>(datas, HttpStatus.OK);
    }

    @GetMapping("/list_lite/{id_project}")
    public ResponseEntity getDataLite(@PathVariable int id_project) {

        List datas = modulDao.getList(id_project);
        return new ResponseEntity (datas, HttpStatus.OK);
    }

    @GetMapping("/detail_lite/{id_modul}")
    public ResponseEntity getDetailLite(@PathVariable int id_modul)
    {
        Modul modul = modulDao.getDetailLite(id_modul);

        if(modul !=null)
        {
            return new ResponseEntity(modul,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }

    @GetMapping("/pre_add/{id_project}")
    public ResponseEntity getPreAdd(@PathVariable int id_project)
    {
        Object modul = modulDao.getPreAdd(id_project);

        if(modul !=null)
        {
            return new ResponseEntity(modul,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Modul modul)
    {
        modulDao.add(modul);
        return new ResponseEntity(modul,HttpStatus.OK);
    }
    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody Modul modul)
    {
        modulDao.edit(modul);
        return new ResponseEntity(modul,HttpStatus.OK);
    }


}
