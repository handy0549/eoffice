package com.arifin.pm.dao.project;

import com.arifin.pm.model.Project;

import java.util.List;
import java.util.Map;

public interface ProjectDao {
    List<Object[]> getAll(Map<String,String > param,Boolean page);
    boolean create(Project project);
    boolean update(int id, Project project);
    Object detail(int id);
}
