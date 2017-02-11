package com.arifin.pm.controller;

import com.arifin.pm.dao.project.AddendumDao;
import com.arifin.pm.model.Addendum;
import com.arifin.pm.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ojiepermana on 2/3/2017.
 */
@RestController
@RequestMapping("/pm/addendum")
public class AddendumCont {
    private final Logger LOG = LoggerFactory.getLogger(DokumenCont.class);

    @Autowired
    ProjectService projectService;

    @Autowired
    AddendumDao addendumDao;

    @GetMapping("")
    public ResponseEntity getAll()
    {
        List<Object> addenda = addendumDao.getAll();
        return ResponseEntity.ok(addenda);
    }

    @GetMapping("/{id_project}")
    public ResponseEntity getDetail(@PathVariable("id_project") int id_project)
    {
        List<Addendum> addenda = addendumDao.getAllLite(id_project);
        return ResponseEntity.ok(addenda);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Addendum addendum)
    {
        projectService.createdAddendum(addendum);
        return ResponseEntity.ok(addendum);
    }
}
