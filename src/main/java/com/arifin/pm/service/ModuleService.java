package com.arifin.pm.service;

import com.arifin.pm.dao.project.ModulDao;
import com.arifin.pm.dao.task.TaskDao;
import com.arifin.pm.model.Modul;
import com.arifin.pm.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ojiepermana on 11/23/2016.
 */
@Transactional
@Component
@Service
public class ModuleService {

    @Autowired
    ModulDao modulDao;
    @Autowired
    TaskDao taskDao;

    public List<Object> getAllModul(int id_project)
    {
        //modul loop
        List<Modul> moduls = modulDao.getList(id_project);
        List<Object> datas = new ArrayList<Object>();

        for(Modul x : moduls)
        {
            //task loop
            List<Task> tasks = taskDao.getAllModul(x.getId_modul());
            Object rekap_modul = modulDao.getProgressTask(x.getId_modul());

            Map<String,Object> map = new HashMap<>();
                map.put("modul", x);
                map.put("task", tasks);
                map.put("rekap_modul", rekap_modul);

            datas.add(map);
        }

        return datas;
    }




}
