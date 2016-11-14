package com.arifin.pm.controller;

import com.arifin.helper.MappingCore;
import com.arifin.pm.dao.TaskDao;
import com.arifin.pm.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
@RestController
public class TaskCont {
    private final Logger LOG = LoggerFactory.getLogger(TaskCont.class);

    @Autowired
    private TaskDao taskDao;

    @GetMapping("/pm/task")
    public ResponseEntity<MappingCore> getTaskFilter (@RequestParam Map<String,String> param) {

        List TOTAL = taskDao.getAll(param, false);
        List datas = taskDao.getAll(param, true);
        MappingCore obj = new MappingCore();

        obj.setDatas(datas);
        obj.setJumlah(datas.size());
        obj.setTotal(TOTAL.size());
        obj.setParam(param);

        return new ResponseEntity<MappingCore>(obj, HttpStatus.OK);
    }
}
