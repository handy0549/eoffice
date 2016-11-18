package com.arifin.pm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.arifin.Umum.dao.LokasiDao;
import com.arifin.Umum.model.Kabkot;
import com.arifin.Umum.model.Kecematan;
import com.arifin.Umum.model.Kelurahan;
import com.arifin.Umum.model.Provinsi;
import com.arifin.helper.QueryHelp;
import com.arifin.pm.dao.perusahaan.PerusahaanDao;
import com.arifin.pm.model.Perusahaam_kategori;
import com.arifin.pm.model.Perusahaan;
import com.arifin.pm.service.PerusahaanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by etos on 11/2/2016.
 */
@RequestMapping(value = "/pm/perusahaan")
@RestController
public class PerusahaanCont {
    private final Logger LOG = LoggerFactory.getLogger(PerusahaanCont.class);

    @Autowired
    private PerusahaanService perusahaanService;

    @Autowired
    private LokasiDao lokasiDao;

    @Autowired
    private PerusahaanDao perusahaanDao;

    @Autowired
    QueryHelp queryHelp;

    @GetMapping( "")
    public ResponseEntity<List<Map<String, Object>>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Object[]> datas = perusahaanDao.getAll();
        for (Object[] row : datas) {
            Perusahaan perusahaan= (Perusahaan) row[0];
            Kelurahan kelurahan = (Kelurahan) row[1];
            Kecematan kecematan = (Kecematan) row[2];
            Kabkot kabkot = (Kabkot) row[3];
            Provinsi provinsi = (Provinsi) row[4];
            Perusahaam_kategori kategori= (Perusahaam_kategori) row[5];

            Map<String, Object> dummyData = new HashMap<>();
            dummyData.put("perusahaan", perusahaan);
            dummyData.put("kelurahan", kelurahan);
            dummyData.put("kecematan", kecematan);
            dummyData.put("kabkot", kabkot);
            dummyData.put("provinsi", provinsi);
            dummyData.put("kategori", kategori);

            out.add(dummyData);
        }

        return new ResponseEntity<List<Map<String, Object>>>(out, HttpStatus.OK);
    }



    @GetMapping(value = "/detail/{id_perusahaan}")
    public ResponseEntity getDetail(@PathVariable int id_perusahaan)
    {
        Object perusahaan = perusahaanDao.getDetail(id_perusahaan);
        if(perusahaan != null)
        {
            return new ResponseEntity(perusahaan,HttpStatus.OK);
        }
        return new ResponseEntity("data Kosong",HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity addPerusahaan(@RequestBody Perusahaan json)
    {
        if(!perusahaanDao.create(json))
        {
            return new ResponseEntity ("error", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity (json, HttpStatus.CREATED);
    }







}
