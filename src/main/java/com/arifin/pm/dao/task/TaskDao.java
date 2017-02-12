package com.arifin.pm.dao.task;

import com.arifin.pm.model.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
public interface TaskDao {
    List<Object> getAllProject( Map<String, String> param,int id_project);
    List<Task> getAllModul(int id_modul);
    boolean create(Task task);
    boolean edit(Task task);
    Object detail(int id_task);
    Task detailLite(int id);
    Object detailPreAdd(int id);

    Object getAllPreAdd(int id_task);

    boolean deleted(Task task);

}
