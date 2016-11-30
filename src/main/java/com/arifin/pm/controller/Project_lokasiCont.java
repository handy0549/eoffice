package com.arifin.pm.controller;

import com.arifin.pm.dao.project.Project_lokasiDao;
import com.arifin.pm.model.Project_lokasi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ojiepermana on 11/25/2016.
 */
@RestController
@RequestMapping(value = "/pm/project/lokasi")
public class Project_lokasiCont {
    @Autowired
    Project_lokasiDao lokasiDao;

    @GetMapping(value = "/{id_project}")
    public ResponseEntity getAll(@PathVariable int id_project)
    {
        List lokasis = lokasiDao.getAll(id_project);
        return new ResponseEntity(lokasis, HttpStatus.OK);
    }

    @GetMapping(value = "/detail_lite/{id_lokasi}")
    public ResponseEntity getDetailLite(@PathVariable int id_lokasi)
    {
        Project_lokasi lokasi =lokasiDao.getDetailLite(id_lokasi);
        if(lokasi !=null)
        {
            return new ResponseEntity(lokasi,HttpStatus.OK);
        }
        return new ResponseEntity("Lokai TIdak ditemukan",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Project_lokasi lokasi)
    {
        if(lokasiDao.add(lokasi))
        {
            return new ResponseEntity(lokasi,HttpStatus.OK);
        }
        return new ResponseEntity("gagal simpan",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody Project_lokasi lokasi)
    {
        if(lokasiDao.edit(lokasi))
        {
            return new ResponseEntity(lokasi,HttpStatus.OK);
        }
        return new ResponseEntity("gagal simpan",HttpStatus.BAD_REQUEST);
    }
}
