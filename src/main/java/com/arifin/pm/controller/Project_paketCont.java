package com.arifin.pm.controller;

import com.arifin.pm.dao.Project_paketDao;
import com.arifin.pm.model.Project_paket;
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
 * Created by Handy on 10/11/2016.
 */
@RestController
public class Project_paketCont {
    private final Logger LOG = LoggerFactory.getLogger(Project_paketCont.class);

    @Autowired
    private Project_paketDao project_paketDao;

    @GetMapping("/pm/project_paket")
    public ResponseEntity<List<Project_paket>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Project_paket> datas = project_paketDao.getList();

        return new ResponseEntity<List<Project_paket>>(datas, HttpStatus.OK);
    }
}
