package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Project;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 12/7/2016.
 */
@Transactional
@Component
public class GrafikDao extends AbstractDao<Integer,Project>{

    //sub_laporan per task
//    public List getLaporanPerTask(int id_task)
//    {
//
//
//    }
}
