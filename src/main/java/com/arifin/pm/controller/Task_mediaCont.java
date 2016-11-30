package com.arifin.pm.controller;

import com.arifin.pm.dao.task.Task_report_media_dao;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ojiepermana on 11/25/2016.
 */
@RestController
@RequestMapping(value = "/pm/project/task/media")
public class Task_mediaCont {

    @Autowired
    Task_report_media_dao mediaDao;

    @GetMapping(value = "/{id_task}")
    public ResponseEntity getAll(@PathVariable int id_task)
    {
        List medias = mediaDao.getAlltask(id_task);
        return new ResponseEntity(medias, HttpStatus.OK);
    }
}
