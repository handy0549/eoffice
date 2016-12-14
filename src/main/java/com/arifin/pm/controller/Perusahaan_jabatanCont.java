package com.arifin.pm.controller;

import com.arifin.pm.dao.perusahaan.Perusahaan_jabatanDao;
import com.arifin.pm.model.Perusahaan_jabatan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ojiepermana on 12/3/2016.
 */
@RestController
@RequestMapping("/pm/perusahaan/jabatan")
public class Perusahaan_jabatanCont {

    @Autowired
    Perusahaan_jabatanDao perusahaan_jabatanDao;

    @GetMapping("")
    public ResponseEntity getAll()
    {
        List<Perusahaan_jabatan>  perusahaan_jabatens = perusahaan_jabatanDao.getAll();
        return ResponseEntity.ok(perusahaan_jabatens);
    }
}
