package com.arifin.pm.dao.project;

import com.arifin.pm.model.Modul;

import java.util.List;

/**
 * Created by Handy on 08/11/2016.
 */
public interface ModulDao {
//    List<Object[]> getAll();
    List<Modul> getList(int id_project);
    Modul getDetailLite(int id_modul);
    Boolean add(Modul modul);
    Boolean edit(Modul modul);



}
