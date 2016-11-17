package com.arifin.pm.controller;

import com.arifin.pm.dao.perusahaan.Perusaahaan_IzinDao;
import com.arifin.pm.model.Perusahaan_Izin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 09/11/2016.
 */

@RestController
public class Perusahaan_IzinCont {
    private final Logger LOG = LoggerFactory.getLogger(Perusahaan_Izin.class);

    @Autowired
    private Perusaahaan_IzinDao perusaahaan_izinDao;

    @GetMapping("/pm/perusahaan_izin")
    public ResponseEntity<List<Perusahaan_Izin>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Perusahaan_Izin> datas = perusaahaan_izinDao.getList();

        return new ResponseEntity<List<Perusahaan_Izin>>(datas, HttpStatus.OK);
    }
}
