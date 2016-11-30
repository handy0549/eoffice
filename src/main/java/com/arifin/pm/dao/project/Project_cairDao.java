package com.arifin.pm.dao.project;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Project_cair;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by etos on 11/28/2016.
 */
@Transactional
@Component
public class Project_cairDao extends AbstractDao<Integer,Project_cair>{

    public List<Project_cair> getAll(int id_project)
    {
        List<Project_cair> cairs = getSession().createCriteria(Project_cair.class)
                .add(Restrictions.eq("id_project",id_project))
                .addOrder(Order.asc("id_cair"))
                .list();
        return cairs;
    }

    public Object getPreAdd(int id_project)
    {
        String Sql = " SELECT\n" +
                "  count(b.ID_CAIR) as total,\n" +
                "  sum(b.JUMLAH_CAIR) as jumlah_cair,\n" +
                "  sum(b.PROGRESS) as PROGRESS,\n" +
                "  sum(b.REALISASI_CAIR) as REALISASI_CAIR,\n" +
                "  sum(b.REALISASI_PROGRESS) as REALISASI_PROGRESS\n" +
                "\n" +
                "  From PM_PROJECT a\n" +
                "LEFT JOIN PM_PROJECT_CAIR b on (a.ID_PROJECT = b.id_project and b.IS_DELETED < 1)\n" +
                "where a.ID_PROJECT = " + id_project +"\n" +
                "GROUP BY a.ID_PROJECT ";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        return query.uniqueResult();
    }
    public Project_cair getDetail(int id_cair)
    {
        Project_cair cair = (Project_cair) getSession().get(Project_cair.class,id_cair);
        return cair;
    }

    public boolean add(Project_cair cair)
    {
        persist(cair);
        return true;
    }

    public boolean edit(Project_cair cair)
    {
        update(cair);
        return true;
    }

}
