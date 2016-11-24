package com.arifin.pm.dao.project;

import com.arifin.pm.model.Project;
import com.arifin.pm.model.Project_paket;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
public interface Project_paketDao {
    List getList(Map<String,String> param);
    boolean add(Project_paket project_paket);
    boolean edit(Project_paket project_paket);
    Object getDetail(int id);
    Project_paket getDetailLite(int id);

}
