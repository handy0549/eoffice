package com.arifin.pm.controller;

import com.arifin.pm.dao.ProjectDao;
import com.arifin.pm.model.Project_jenis;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by ojiepermana on 11/10/2016.
 */
@Controller
@RestController
public class ProjectCont {
    private final Logger LOG = LoggerFactory.getLogger(PerusahaanCont.class);

    @Autowired
    ProjectDao projectDao;

    @GetMapping("/pm/projects")
    public ResponseEntity<String> getProjects()
    {
        List datas = projectDao.getAll();
        JSONObject obj = new JSONObject();
        obj.put("jumlah", datas.size());
        obj.put("data",datas);
        return new ResponseEntity<String>(obj.toString(), HttpStatus.OK);
    }

    @GetMapping(value = "/pm/project/add")
    public ResponseEntity<String> addProject(@RequestParam Map<String,String> json)
    {
        System.out.print("ss"  + json.get("jumlah"));
        String param = "ASd";
        return new ResponseEntity<String>(param, HttpStatus.OK);
    }

    @PostMapping(value = "/pm/project/add")
    public ResponseEntity<String> saveProject(@ModelAttribute Map<String,Object> json)
    {
        System.out.print("ss"  + json.get("jumlah") + json.size());
        String param = "ASd";
        return new ResponseEntity<String>(param, HttpStatus.OK);
    }
}
