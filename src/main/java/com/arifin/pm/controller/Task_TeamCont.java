package com.arifin.pm.controller;

import com.arifin.pm.dao.Task_TeamDao;
import com.arifin.pm.model.Task_Team;
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
 * Created by Handy on 11/11/2016.
 */
@RestController
public class Task_TeamCont {
    private final Logger LOG = LoggerFactory.getLogger(Task_TeamCont.class);

    @Autowired
    private Task_TeamDao task_teamDao;

    @GetMapping("/pm/task_team")
    public ResponseEntity<List<Task_Team>> getData() {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Task_Team> datas = task_teamDao.getList();

        return new ResponseEntity<List<Task_Team>>(datas, HttpStatus.OK);
    }
}
