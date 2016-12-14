package com.arifin.pm.dao.project;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Modul;
import com.arifin.pm.model.Task;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 08/11/2016.
 */


@Repository
@Transactional
public class ModulDaoImp extends AbstractDao<Integer, Modul> implements ModulDao {

    @Override
    public List<Modul> getList(int id_project) {
        Criteria criteria = getSession().createCriteria(Modul.class);
        criteria.add(Restrictions.eq("id_project",id_project));
        criteria.add(Restrictions.eq("is_deleted",0));
        criteria.addOrder(Order.asc("urutan"));
        criteria.addOrder(Order.asc("id_modul"));
        return (List<Modul>) criteria.list();
    }

    @Override
    public Modul getDetailLite(int id_modul) {
        Modul modul = (Modul) getSession().get(Modul.class,id_modul);
        return modul;
    }

    @Override
    public Boolean add(Modul modul) {
        persist(modul);
        return true;
    }

    @Override
    public Boolean edit(Modul modul) {
        update(modul);
        return true;
    }

    @Override
    public Object getPreAdd(int id_project) {
        String Sql =" SELECT\n" +
                "  sum(a.MODUL_PROGRES) as total,\n" +
                "  sum(a.MODUL_PROGRESS_REALISASI/100*a.MODUL_PROGRES) as MODUL_PROGRESS_REALISASI,\n" +
                "  sum(a.MODUL_PROGRES) as MODUL_PROGRES " +
                "  FROM PM_PROJECT x\n" +
                "    LEFT JOIN PM_MODUL a on (a.ID_PROJECT=x.ID_PROJECT and a.is_deleted=0 )  \n" +
                "    where x.ID_PROJECT="+ id_project + "\n" +
                "GROUP BY x.ID_PROJECT\n ";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        return query.uniqueResult();
    }


    @Override
    public Modul upDateModul(Task task) {
        Modul modul = getMaxModul(task.getId_modul());

        if(modul.getModul_progress_realisasi() <= 100)
        {
            Object modulProgress = getProgressTask(task.getId_modul());
            //System.out.println(modulProgress.size() + " " + modulProgress);
            Map row = (Map)modulProgress;
            //long progress = row.getProgressTasket("total_task_progress_realisasi");//TOTAL_TASK_PROGRESS_REALISASI

            System.out.println("dibawah 100");
            String Sql =" Update PM_MODUL set MODUL_PROGRESS_REALISASI = "+ row.get("TOTAL_TASK_PROGRESS_REALISASI") +"\n" +
                    "WHERE ID_MODUL=" + modul.getId_modul();
            SQLQuery query = getSession().createSQLQuery(Sql);
            query.executeUpdate();
            return modul;
        }
        else
        {
            return null;
        }


    }

    private Modul getMaxModul(int id_modul)
    {
        Modul modul = (Modul) getSession().get(Modul.class,id_modul);
        System.out.println("modul realisai" + modul.getModul_progress_realisasi());
        return modul;
    }

    @Override
    public Object getProgressTask(int id_modul)
    {
        String Sql = "SELECT count(b.ID_TASK) as TOTAL_TASK,\n" +
                "sum(b.TASK_PROGRESS) as TOTAL_PROGRESS,\n" +
                "  sum(b.TASK_PROGRESS_REALISASI/100*b.TASK_PROGRESS) as TOTAL_TASK_PROGRESS_REALISASI, \n" +
                "sum(b.TASK_FEE*b.TASK_NILAI) as total_biaya_task \n" +
                "from\n" +
                "  PM_MODUL a\n" +
                "  LEFT JOIN PM_TASK b on (a.ID_MODUL=b.ID_MODUL and b.IS_DELETED < 1)\n" +
                "WHERE a.ID_MODUL = " + id_modul ;
        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        Object row =  query.uniqueResult();
        return row;
    }
}
