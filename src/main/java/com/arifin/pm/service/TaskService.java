package com.arifin.pm.service;

import com.arifin.pm.dao.project.ProjectDao;
import com.arifin.pm.dao.task.TaskCheckDao;
import com.arifin.pm.dao.task.TaskDao;
import com.arifin.pm.dao.task.Task_ReportDao;
import com.arifin.pm.model.Task;
import com.arifin.pm.model.Task_Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ojiepermana on 11/24/2016.
 */
@Transactional
@Component
public class TaskService {

    @Autowired
    TaskCheckDao taskCheckDao;
    @Autowired
    TaskDao taskDao;
    @Autowired
    Task_ReportDao task_reportDao;
    @Autowired
    ProjectDao projectDao;

    public Object getTaskDetail(int id_task)
    {
        Task task= taskDao.detailLite(id_task);
        Object check_rangkum = taskCheckDao.getRangkum(id_task);
        Object rekap_report = task_reportDao.getTaskReport(id_task);
        Object perusahaan = projectDao.getProjectPerusahaan(id_task);

        Map<String,Object> map = new HashMap<>();
        map.put("task",task);
        map.put("report_rekap",rekap_report);
        map.put("check_rangkum",check_rangkum);
        map.put("perusahaan",perusahaan);

        return map;
    }


//    simpan laporan
    public Object addReport()
    {
        //insert task_report



        //insert media

        //update task
        //update project

        return false;
    }

}
