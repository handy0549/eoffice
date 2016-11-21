package com.arifin.pm.controller;

import com.arifin.pm.dao.master.PmMasterDao;
import com.arifin.pm.model.Perusahaam_kategori;
import com.arifin.pm.model.Perusahaan_jabatan;
import com.arifin.pm.model.Project_jenis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ojiepermana on 11/15/2016.
 */
@RestController
@Controller
public class PmMasterCont {

    @Autowired
    PmMasterDao pmMasterDao;

    @GetMapping(value = "/pm/master/kategori_perusahaan")
    public ResponseEntity getKategoriPerusahaan()
    {
        List<Perusahaam_kategori> perusahaam_kategoris = pmMasterDao.listPerusahaanKategori();
        return new ResponseEntity(perusahaam_kategoris, HttpStatus.OK);
    }

    @GetMapping(value = "/pm/master/jenis_project")
    public ResponseEntity getJenisProject()
    {
        List<Project_jenis> perusahaam_kategoris = pmMasterDao.listProjectJenis();
        return new ResponseEntity(perusahaam_kategoris, HttpStatus.OK);
    }

    @GetMapping(value = "/pm/master/jabatan_perusahaan")
    public ResponseEntity getjabatanPerusahaan()
    {
        List<Perusahaan_jabatan> perusahaan_jabaten = pmMasterDao.listPerusahaanJabatan();
        return new ResponseEntity(perusahaan_jabaten, HttpStatus.OK);
    }



}
