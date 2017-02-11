package com.arifin.pm.controller;

import com.arifin.pm.dao.task.Task_ReportDao;
import com.arifin.pm.model.Task_Report;
import com.arifin.pm.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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

    @Autowired
    TaskService taskService;

    @GetMapping("/{id_task}")
    public ResponseEntity getData(@PathVariable int id_task) {

        List datas = task_reportDao.getAll(id_task);

        return new ResponseEntity(datas, HttpStatus.OK);
    }

    @GetMapping("/detail/{id_task_report}")
    public ResponseEntity getDetail(@PathVariable int id_task_report)
    {
        Map report = (Map) taskService.getDetailLaporan(id_task_report);
        return new ResponseEntity(report,HttpStatus.OK);
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

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody HashMap<String,Map<String,String>> param)
    {
        taskService.addReport(param);

        return new ResponseEntity("[]",HttpStatus.OK);

    }
    @PostMapping("/add_lite")
    public ResponseEntity addLite(@RequestBody Task_Report param)
    {
        Task_Report report = taskService.addReportLite(param);
        return new ResponseEntity(report,HttpStatus.OK);

    }

}
