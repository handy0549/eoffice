package com.arifin.pm.dao.project;

import com.arifin.pm.model.Modul;
import com.arifin.pm.model.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 08/11/2016.
 */
public interface ModulDao {
//    List<Object[]> getAll();
    List<Modul> getList(int id_project);
    Modul getDetailLite(int id_modul);
    Boolean add(Modul modul);
    Boolean edit(Modul modul);

    Object getPreAdd(int id_project);
    Modul upDateModul(Task task);
    Object getProgressTask(int id_modul);

    boolean deleted(Modul modul);

}
