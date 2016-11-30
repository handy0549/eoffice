package com.arifin.pm.dao.task;

import com.arifin.pm.model.Task_Team;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 11/11/2016.
 */
public interface Task_TeamDao {
    List<Object[]> getAll(int id_task, Map<String,String> param);
    List getList();

    boolean deleted(int id_task_team);

    boolean add(Task_Team task_team);
    boolean edit(Task_Team task_team);

    boolean hapus(int id_task_team);

}
