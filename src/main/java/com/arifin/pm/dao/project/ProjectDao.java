package com.arifin.pm.dao.project;

import com.arifin.pm.model.Modul;
import com.arifin.pm.model.Project;

import java.util.List;
import java.util.Map;

public interface ProjectDao {
    List<Object[]> getAll(Map<String,String > param,Boolean page);
    boolean create(Project project);
    boolean update(int id, Project project);
    Object detail(int id);
    Project detailLite(int id);


    //atribut- tools
    //ambil perusaan kontraktor - supervisi untuk task detail
    Object getProjectPerusahaan(int id_project);
    Object getReportSerapanAnggaranTask(int id_project);

    Project UpdateTaskProject(Modul modul);
}
