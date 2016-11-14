package com.arifin.pm.controller;

import com.arifin.pm.dao.Task_ReportDao;
import com.arifin.pm.model.Task_Report;
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
public class Task_ReportCont {
    private final Logger LOG = LoggerFactory.getLogger(Task_ReportCont.class);

    @Autowired
    private Task_ReportDao task_reportDao;

    @GetMapping("pm/task_report")
    public ResponseEntity<List<Task_Report>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Task_Report> datas = task_reportDao.getList();

        return new ResponseEntity<List<Task_Report>>(datas, HttpStatus.OK);
    }
}
