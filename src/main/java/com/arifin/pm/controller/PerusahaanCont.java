package com.arifin.pm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.arifin.model.Kabkot;
import com.arifin.model.Kecematan;
import com.arifin.model.Kelurahan;
import com.arifin.model.Provinsi;
import com.arifin.pm.dao.PerusahaanDao;
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
@RestController
public class PerusahaanCont {
    private final Logger LOG = LoggerFactory.getLogger(PerusahaanCont.class);

    @Autowired
    private PerusahaanService perusahaanService;

    @Autowired
    private PerusahaanDao perusahaanDao;

    @GetMapping("/pm/perusahaan")
    public ResponseEntity<List<Map<String, Object>>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Object[]> datas = perusahaanDao.getAll();
        for (Object[] row : datas) {
            Perusahaan perusahaan= (Perusahaan) row[0];
            Kelurahan kelurahan = (Kelurahan) row[1];
            Kecematan kecematan = (Kecematan) row[2];
            Kabkot kabkot = (Kabkot) row[3];
            Provinsi provinsi = (Provinsi) row[4];

            Map<String, Object> dummyData = new HashMap<>();
            dummyData.put("perusahaan", perusahaan);
            dummyData.put("kelurahan", kelurahan);
            dummyData.put("kecematan", kecematan);
            dummyData.put("kabkot", kabkot);
            dummyData.put("provinsi", provinsi);

            out.add(dummyData);
        }

        return new ResponseEntity<List<Map<String, Object>>>(out, HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity createCustomer(@RequestBody Perusahaan perusahaan) {

//        if (perusahaanDao.create(perusahaan))
//        {
//
//        }
//        {
//            LOG.info("Gagal Simpan");
//            return new ResponseEntity<Perusahaan>(HttpStatus.NOT_FOUND);
//        }

        return new ResponseEntity(perusahaan, HttpStatus.OK);
    }







}
