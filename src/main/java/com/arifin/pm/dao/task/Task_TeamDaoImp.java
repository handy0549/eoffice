package com.arifin.pm.dao.task;

import com.arifin.abstrac.AbstractDao;
import com.arifin.helper.QueryHelp;
import com.arifin.helper.ToSql;
import com.arifin.pm.model.Task_Team;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 11/11/2016.
 */
@Repository("Task_TeamDaoImp")
@Transactional
public class Task_TeamDaoImp extends AbstractDao<Integer, Task_Team> implements Task_TeamDao{

    @Autowired
    ToSql toSql;

    @Override
    public List<Object[]> getAll(int id_task, Map<String,String> param) {

        String Sql = "SELECT\n" +
                "c.JABATAN,\n" +
                "  b.*, \n" +
                " a.id_task_team \n" +
                "FROM PM_TASK_TEAM a,\n" +
                "  PM_PERUSAHAAN_PEGAWAI b, " +
                " T_PERUSAHAAN_JABATAN c " +
                "\n" +
                "WHERE a.ID_PERUSAHAAN_PEGAWAI=b.ID_PERUSAHAAN_PEGAWAI\n" +
                " AND b.ID_JABATAN_P=c.ID_JABATAN_P " +
                "      and a.TEAM_STATUS > 0\n " +
                "and a.id_task = " + id_task;

        Sql=toSql.Where(Sql, param ,"a", false);


        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();
        return rows;

    }

    @Override
    public List<Task_Team> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Task_Team>) criteria.list();
    }

    @Override
    public boolean deleted(int id_task_team) {
        //delete(Task_Team.class,id_task_team);
        return false;
    }

    @Override
    public boolean add(Task_Team task_team) {
        persist(task_team);
        return true;
    }

    @Override
    public boolean edit(Task_Team task_team) {
        update(task_team);
        return true;
    }

    @Override
    public boolean hapus(int id_task_team)
    {
        Task_Team task_team = new Task_Team();
        task_team.setId_task_team(id_task_team);
        delete(task_team);
        return true;
    }
}
