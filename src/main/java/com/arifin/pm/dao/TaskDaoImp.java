package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Task;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 10/11/2016.
 */
@Repository
@Transactional
public class TaskDaoImp extends AbstractDao<Integer, Task> implements TaskDao {

    @Override
    public List<Object[]> getAll() {
        return null;
    }

    @Override
    public List<Task> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Task>) criteria.list();
    }
}
