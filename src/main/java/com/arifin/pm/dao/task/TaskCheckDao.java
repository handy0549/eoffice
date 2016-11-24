package com.arifin.pm.dao.task;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Task;
import com.arifin.pm.model.Task_check;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 11/24/2016.
 */
@Transactional
@Component
public class TaskCheckDao extends AbstractDao<Integer,Task_check>{

    public List<Task_check> getTaskChecks(int id_task)
    {
        List<Task_check> datas = (List<Task_check>) getSession().createCriteria(Task_check.class)
                .add(Restrictions.eq("id_task",id_task))
                .add(Restrictions.eq("is_deleted",0))
                .list();

        return datas;
    }

    public Object getRangkum(int id_task)
    {
        String Sql="SELECT  \n" +
                "  sum(CASE\n" +
                "    WHEN a.STATUS_CHECK='open'\n" +
                "      THEN 1\n" +
                "      ELSE 0\n" +
                "    END\n" +
                "    ) as open,\n" +
                "  sum(CASE\n" +
                "      WHEN a.STATUS_CHECK='close'\n" +
                "        THEN 1\n" +
                "      ELSE 0\n" +
                "      END\n" +
                "  ) as close,\n" +
                "  count(a.ID_TASK_CHECK) as total\n" +
                "\n" +
                "  FROM PM_TASK_CHECK a\n" +
                " where a.id_task=" + id_task + " " +
                "GROUP BY a.ID_TASK";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        return  query.uniqueResult();
    }

    public Task_check detail(int id_check)
    {
        return (Task_check) getSession().get(Task_check.class,id_check);
    }

    public boolean add(Task_check taskCheck)
    {
        persist(taskCheck);
        return  true;
    }

    public boolean edit(Task_check taskCheck)
    {
        update(taskCheck);
        return true;
    }
}
