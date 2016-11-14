package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Task_Team;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 11/11/2016.
 */
@Repository
@Transactional
public class Task_TeamDaoImp extends AbstractDao<Integer, Task_Team> implements Task_TeamDao{

    @Override
    public List<Object[]> getAll() {
        return null;
    }

    @Override
    public List<Task_Team> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Task_Team>) criteria.list();
    }
}
