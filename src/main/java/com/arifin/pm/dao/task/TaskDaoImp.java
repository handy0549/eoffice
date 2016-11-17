package com.arifin.pm.dao.task;

import com.arifin.abstrac.AbstractDao;
import com.arifin.helper.ToSql;
import com.arifin.pm.model.Project;
import com.arifin.pm.model.Task;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
@Repository("TaskDaoImp")
@Transactional
public class TaskDaoImp extends AbstractDao<Integer, Task> implements TaskDao {

    @Autowired
    ToSql toSql;

    @Override
    public List getAll(Map<String, String> param, Boolean page) {
        String Sql = "SELECT {a.*}, {b.*} " +
                "FROM PM_TASK a, " +
                "PM_PROJECT b, " +
                "PM_MODUL c " +
                "WHERE a.id_modul = c.id_modul " +
                "and b.id_project = c.id_project ";

        SQLQuery query = getSession().createSQLQuery(Sql);
//        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        query.addEntity("a", Task.class);
        query.addEntity("b", Project.class);
        List rows = query.list();

        return rows;
    }

    @Override
    public boolean create(Task task) {
        return false;
    }

    @Override
    public boolean update(int id, Task task) {
        return false;
    }

    @Override
    public Task detail(int id) {
        return null;
    }

//    @Override
//    public List<Task> getList() {
//        Criteria criteria = createEntityCriteria();
//        return (List<Task>) criteria.list();
//    }
}
