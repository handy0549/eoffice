package com.arifin.pm.controller;

import com.arifin.helper.MappingCore;
import com.arifin.pm.dao.task.TaskDao;
import com.arifin.pm.model.Modul;
import com.arifin.pm.model.Task;
import com.arifin.pm.service.ModuleService;
import com.arifin.pm.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
@RestController
@RequestMapping(value = "/pm/project/task")
public class TaskCont {
    private final Logger LOG = LoggerFactory.getLogger(TaskCont.class);

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskService taskService;


    @GetMapping("/{id_project}")
    public ResponseEntity getTaskFilter (@RequestParam Map<String,String> param, @PathVariable int id_project) {

        List tasks = taskDao.getAllProject(param,id_project);
        return new ResponseEntity(tasks, HttpStatus.OK);

    }

    //menampilkan ID#######
    @GetMapping("/detail_id_id/{id_task}")
    public ResponseEntity getAllPreAdd(@PathVariable int id_task)
    {
        Object task= taskDao.getAllPreAdd(id_task);

        if(task !=null)
        {
            return new ResponseEntity(task,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }

    @GetMapping("/detail/{id_task}")
    public ResponseEntity getDetail(@PathVariable int id_task)
    {
        Object task = taskService.getTaskDetail(id_task);

        if(task !=null)
        {
            return new ResponseEntity(task,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }

    @GetMapping("/detail_pre_add/{id_modul}")
    public ResponseEntity getDetailPreAdd(@PathVariable int id_modul)
    {
        Object task= taskDao.detailPreAdd(id_modul);

        if(task !=null)
        {
            return new ResponseEntity(task,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }

    @GetMapping("/detail_lite/{id_task}")
    public ResponseEntity getDetailLite(@PathVariable int id_task)
    {
        Task task= taskDao.detailLite(id_task);

        if(task !=null)
        {
            return new ResponseEntity(task,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Task task)
    {
        taskDao.create(task);
        return new ResponseEntity(task,HttpStatus.OK);
    }
    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody Task task)
    {
        taskDao.edit(task);
        return new ResponseEntity(task,HttpStatus.OK);
    }
}
