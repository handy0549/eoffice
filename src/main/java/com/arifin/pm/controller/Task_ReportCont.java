package com.arifin.pm.controller;

import com.arifin.pm.dao.task.Task_ReportDao;
import com.arifin.pm.model.Task_Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
@RestController
@RequestMapping("pm/project/task/report")
public class Task_ReportCont {
    private final Logger LOG = LoggerFactory.getLogger(Task_ReportCont.class);

    @Autowired
    private Task_ReportDao task_reportDao;

    @GetMapping("/{id_task}")
    public ResponseEntity getData(@PathVariable int id_task) {

        List datas = task_reportDao.getAll(id_task);

        return new ResponseEntity(datas, HttpStatus.OK);
    }

    @GetMapping("/detail/{id_task_report)")
    public ResponseEntity getDetail(@PathVariable int id_task_report)
    {
        Object report = task_reportDao.getDetail(id_task_report);
        if(report != null)
        {
            return new ResponseEntity(report,HttpStatus.OK);
        }
        return new ResponseEntity("data tidak ditemukan", HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/detail_report/{id_task}")
    public ResponseEntity getReport(@PathVariable int id_task)
    {
        Object report = task_reportDao.getTaskReport(id_task);
        if(report != null)
        {
            return new ResponseEntity(report,HttpStatus.OK);
        }
        return new ResponseEntity("data tidak ditemukan",HttpStatus.BAD_REQUEST);
    }

}
