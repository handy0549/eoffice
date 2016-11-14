package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Task_Report;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 10/11/2016.
 */
@Repository
@Transactional
public class Task_ReportDaoImp extends AbstractDao<Integer, Task_Report> implements Task_ReportDao{

    @Override
    public List<Object[]> getAll() {
        return null;
    }

    @Override
    public List<Task_Report> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Task_Report>) criteria.list();
    }
}
