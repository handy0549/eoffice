package com.arifin.pm.dao.task;

import com.arifin.pm.model.Task;
import com.arifin.pm.model.Task_Report;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
public interface Task_ReportDao {
    List<Object[]> getAll(int id_task);
    List<Task_Report> getAllLite(int id_task);
    Object getTaskReport(int id_task);

    Object getDetail(int id_task_report);
    Task_Report getDetailLite(int id_task_report);
    boolean add(Map<String,String> report);
    boolean addLite(Task_Report report);
    boolean edit(Map<String,String> report);
    Task upDateTask(Map<String,String> report);
    Task upDateTaskLite(Task_Report report);
}
