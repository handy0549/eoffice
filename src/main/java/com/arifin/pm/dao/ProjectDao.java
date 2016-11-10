package com.arifin.pm.dao;

import com.arifin.pm.model.Project;

import java.util.List;

public interface ProjectDao {
    List<Object[]> getAll();
    void create(Project project);
}
