package com.arifin.pm.controller;

import com.arifin.pm.dao.ModulDao;
import com.arifin.pm.model.Modul;
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
 * Created by Handy on 08/11/2016.
 */

@RestController
public class ModulCont {
    private final Logger LOG = LoggerFactory.getLogger(ModulCont.class);

    @Autowired
    private ModulDao modulDao;

    @GetMapping("/pm/modul")
    public ResponseEntity<List<Modul>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Modul> datas = modulDao.getList();

        return new ResponseEntity<List<Modul>>(datas, HttpStatus.OK);
    }

}
