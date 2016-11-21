package com.arifin.controller;

import com.arifin.Umum.dao.LokasiDao;
import com.arifin.Umum.model.Kabkot;
import com.arifin.Umum.model.Provinsi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ojiepermana on 11/19/2016.
 */
@RestController
@RequestMapping(value = "/master")
public class MasterCont {

    @Autowired
    LokasiDao lokasiDao;

    @GetMapping("/provinsi")
    public ResponseEntity getProvinsi()
    {
        List data = lokasiDao.allProv();
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/kabkot/{id}")
    public ResponseEntity getKabkot(@PathVariable long id)
    {
        List data = lokasiDao.allKabkot(id);
        return new ResponseEntity(data, HttpStatus.OK);
    }
    @GetMapping("/kecematan/{id}")
    public ResponseEntity getKecematan(@PathVariable long id)
    {
        List data = lokasiDao.allKecematan(id);
        return new ResponseEntity(data, HttpStatus.OK);
    }
    @GetMapping("/kelurahan/{id}")
    public ResponseEntity getKelurahan(@PathVariable long id)
    {
        List data = lokasiDao.allKelurahan(id);
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
