package com.arifin.pm.dao.task;

import com.arifin.abstrac.AbstractDao;
import com.arifin.helper.ToSql;
import com.arifin.pm.model.Project;
import com.arifin.pm.model.Task;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
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
    public List<Object> getAllProject(Map<String, String> param,int id_project) {
        String Sql =  "SELECT " +
                "  a.*, " +
                "  b.modul " +
                "from PM_TASK a, " +
                "  PM_MODUL b " +
                " WHERE a.ID_MODUL=b.ID_MODUL\n" +
                " and b.ID_PROJECT = " + id_project +
                " and a.is_deleted < 1 ";

        Sql=toSql.Where(Sql, param,"a", false);
        Sql+=" ORDER  BY a.id_modul,a.id_task ASC ";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();
        return rows;
    }

    @Override
    public List<Task> getAllModul(int id_modul) {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("id_modul",id_modul));
        return criteria.list();
    }

    @Override
    public boolean create(Task task) {
        persist(task);
        return true;
    }

    @Override
    public boolean edit( Task task) {
        update(task);
        return true;
    }

    @Override
    public Object detail(int id_task) {


        return null;
    }

    @Override
    public Task detailLite(int id) {
        Task task = (Task) getSession().get(Task.class,id);
        return task;
    }

    @Override
    public Object detailPreAdd(int id) {
        String Sql =  "SELECT\n" +
                "  a.*,\n" +
                "  b.ANGGARAN_NILAI,\n" +
                "  c.*\n" +
                "\n" +
                "  FROM PM_MODUL a\n" +
                "    join PM_PROJECT b on a.ID_PROJECT=b.ID_PROJECT\n" +
                "    LEFT JOIN (\n" +
                "      select max(x.ID_MODUL) as C_ID_MODUL,\n" +
                "        sum(x.TASK_PROGRESS) as total_progress,\n" +
                "        sum(x.TASK_FEE*x.TASK_NILAI) as total\n" +
                "      from PM_TASK x\n" +
                "      WHERE x.IS_DELETED < 1\n" +
                "            and x.ID_MODUL=" + id +"\n" +
                "      group by x.ID_MODUL\n" +
                "    ) c ON a.ID_MODUL=c.C_ID_MODUL\n" +
                "\n" +
                "WHERE  a.ID_MODUL=" + id +" ";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        Object rows = query.uniqueResult();
        return rows;
    }
}
