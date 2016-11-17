package com.arifin.pm.controller;

import com.arifin.pm.dao.project.Project_jenisDao;
import com.arifin.pm.model.Project_jenis;
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
public class Project_jenisCont {
    private final Logger LOG = LoggerFactory.getLogger(Project_jenisCont.class);

    @Autowired
    private Project_jenisDao project_jenisDao;

    @GetMapping("/pm/project_jenis")
    public ResponseEntity<List<Project_jenis>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Project_jenis> datas = project_jenisDao.getList();

        return new ResponseEntity<List<Project_jenis>>(datas, HttpStatus.OK);
    }
}
