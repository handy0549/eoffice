package com.arifin.pm.controller;


import com.arifin.pm.dao.DokumenDao;
import com.arifin.pm.model.Dokumen;

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
import java.util.HashMap;


/**
 * Created by Handy on 07/11/2016.
 */
@RestController
public class DokumenCont {
    private final Logger LOG = LoggerFactory.getLogger(DokumenCont.class);

//    @Autowired
//    private DokumenService dokumenService;

    @Autowired
    private DokumenDao dokumenDao;

    @GetMapping("/pm/dokumen")
    public ResponseEntity<List<Dokumen>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Dokumen> datas = dokumenDao.getList();
//        for (Object[] row : datas) {
//            Dokumen dokumen = (Dokumen) row[0];
//
//            Map<String, Object> dummyData = new
//
//       }
        return new  ResponseEntity<List<Dokumen>>(datas, HttpStatus.OK);

    }

}
