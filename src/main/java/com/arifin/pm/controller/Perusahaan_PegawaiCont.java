package com.arifin.pm.controller;

import com.arifin.pm.dao.perusahaan.Perusahaan_PegawaiDao;
import com.arifin.pm.model.Perusahaan_Pegawai;
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
public class Perusahaan_PegawaiCont {
    private final Logger LOG = LoggerFactory.getLogger(Perusahaan_Pegawai.class);

    @Autowired
    private Perusahaan_PegawaiDao perusahaan_pegawaiDao;

    @GetMapping("/pm/perusahaan_pegawai")
    public ResponseEntity<List<Perusahaan_Pegawai>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Perusahaan_Pegawai> datas = perusahaan_pegawaiDao.getList();

        return new ResponseEntity<List<Perusahaan_Pegawai>>(datas, HttpStatus.OK);
    }
}
