package com.arifin.pm.controller;

import com.arifin.pm.dao.task.TaskCheckDao;
import com.arifin.pm.dao.task.TaskDao;
import com.arifin.pm.model.Task_check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ojiepermana on 11/24/2016.
 */
@RestController
@RequestMapping(value = "/pm/project/check")
public class Task_CheckCOnt {

    @Autowired
    private TaskCheckDao taskCheckDao;

    @GetMapping("/{id_task}")
    public ResponseEntity getAll(@PathVariable int id_task)
    {
        List<Task_check> checks = taskCheckDao.getTaskChecks(id_task);
        return new ResponseEntity(checks, HttpStatus.OK);
    }

    @GetMapping("/detail/{id_check}")
    public ResponseEntity getDetail(@PathVariable int id_check)
    {
        Task_check check = taskCheckDao.detail(id_check);
        if(check!=null)
        {
            return new ResponseEntity(check,HttpStatus.OK);
        }
        return new ResponseEntity("check tidak ditemukan",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Task_check check)
    {
        taskCheckDao.add(check);
        return new ResponseEntity(check,HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody Task_check check)
    {
        taskCheckDao.edit(check);
        return new ResponseEntity(check,HttpStatus.OK);
    }
}
