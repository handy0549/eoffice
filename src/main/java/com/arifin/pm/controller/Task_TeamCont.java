package com.arifin.pm.controller;

import com.arifin.pm.dao.task.Task_TeamDao;
import com.arifin.pm.model.Task_Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 11/11/2016.
 */
@RestController
@RequestMapping(value = "pm/project/task/team")
public class Task_TeamCont {
    private final Logger LOG = LoggerFactory.getLogger(Task_TeamCont.class);

    @Autowired
    private Task_TeamDao task_teamDao;

    @GetMapping("/{id_task}")
    public ResponseEntity getData(@PathVariable int id_task, @RequestParam Map<String,String> param) {

        List datas = task_teamDao.getAll(id_task, param);

        return new ResponseEntity(datas, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Task_Team task_team)
    {
        task_teamDao.add(task_team);
        return new ResponseEntity(task_team,HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody Task_Team task_team)
    {
        task_teamDao.edit(task_team);
        return new ResponseEntity(task_team,HttpStatus.OK);
    }

    @GetMapping("/hapus/{id_task_team}")
    public ResponseEntity hapus(@PathVariable int id_task_team)
    {
        task_teamDao.hapus(id_task_team);
        return new ResponseEntity("[]",HttpStatus.OK);
    }
}
