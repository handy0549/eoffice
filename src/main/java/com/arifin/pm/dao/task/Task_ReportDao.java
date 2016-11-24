package com.arifin.pm.dao.task;

import com.arifin.pm.model.Task_Report;

import java.util.List;

/**
 * Created by Handy on 10/11/2016.
 */
public interface Task_ReportDao {
    List<Object[]> getAll(int id_task);
    Object getTaskReport(int id_task);

    Object getDetail(int id_task_report);
    Task_Report getDetailLite(int id_task_report);
    boolean add(Task_Report report);
    boolean edit(Task_Report report);
}
