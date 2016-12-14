package com.arifin.pm.service;

import com.arifin.pm.dao.project.ModulDao;
import com.arifin.pm.dao.project.ProjectDao;
import com.arifin.pm.dao.task.TaskCheckDao;
import com.arifin.pm.dao.task.TaskDao;
import com.arifin.pm.dao.task.Task_ReportDao;
import com.arifin.pm.dao.task.Task_report_media_dao;
import com.arifin.pm.model.Modul;
import com.arifin.pm.model.Task;
import com.arifin.pm.model.Task_Report;
import com.arifin.pm.model.Task_report_media;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    Task_report_media_dao mediaDao;
    @Autowired
    ModulDao modulDao;

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
    public Object getDetailLaporan(int id_task_report)
    {
        Object report = task_reportDao.getDetail(id_task_report);
        List<Task_report_media> media = mediaDao.getAllReport(id_task_report);
        Map<String,Object> map = new HashMap<>();

        map.put("report",report);
        map.put("media",media);

        return map;

    }


//    simpan laporan
    public Object addReport(HashMap<String,Map<String,String>> param)
    {
        //insert report
        if(task_reportDao.add(param.get("laporan")))
        {
            //update task
            Task task = task_reportDao.upDateTask(param.get("laporan"));
            if(task !=null)
            {
                Modul modul = modulDao.upDateModul(task);
                if(modul !=null)
                {
                    projectDao.UpdateTaskProject(modul);
                }
            }
        }




        //insert media



        //update project

        return false;
    }



}
