package com.arifin.pm.dao;

import com.arifin.pm.model.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
public interface TaskDao {
    List<Object[]> getAll(Map<String, String> param, Boolean page);
    boolean create(Task task);
    boolean update(int id, Task task);
    Task detail(int id);
}
