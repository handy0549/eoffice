package com.arifin.pm.dao.project;

import com.arifin.abstrac.AbstractDao;
import com.arifin.helper.ToSql;
import com.arifin.pm.model.Project_paket;
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
@Repository("Project_paketDaoImp")
@Transactional
public class Project_paketDaoImp extends AbstractDao<Integer, Project_paket> implements Project_paketDao {

    @Autowired
    ToSql toSql;

    @Override
    public List getList(Map<String,String> param) {
        Criteria criteria = createEntityCriteria();
        if(param.get("status_lock") != null)
        {
            criteria.add(Restrictions.eq("status_lock",param.get("status_lock")));
        }
        if(param.get("is_deleted") != null)
        {
            criteria.add(Restrictions.eq("is_deleted",param.get("is_deleted")));
        }
        String Sql="select a.*," +
                "b.nama_perusahaan as kontraktor ," +
                "c.NAMA_PERUSAHAAN as supervisi " +
                "from PM_PROJECT_PAKET a " +
                "left join PM_PERUSAHAAN b on a.ID_KONTRAKTOR_PAKET=b.id_perusahaan " +
                "left join PM_PERUSAHAAN c on a.ID_SUPERVISI_PAKET=c.ID_PERUSAHAAN " +
                " WHERE a.id_project_paket != 0 ";

        Sql=toSql.Where(Sql, param,"a", false);
        Sql+=" ORDER by a.id_project_paket DESC";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();


        return rows;
    }

    public Object getDetail(int id)
    {
        String Sql="select a.*, " +
                "b.nama_perusahaan as kontraktor ," +
                "c.NAMA_PERUSAHAAN as supervisi " +
                "from PM_PROJECT_PAKET a " +
                "left join PM_PERUSAHAAN b on a.ID_KONTRAKTOR_PAKET=b.id_perusahaan " +
                "left join PM_PERUSAHAAN c on a.ID_SUPERVISI_PAKET=c.ID_PERUSAHAAN " +
                " WHERE a.id_project_paket = " + id;

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        Object rows = query.uniqueResult();
        return rows;
    }

    public Project_paket getDetailLite(int id)
    {
       return (Project_paket) getSession().get(Project_paket.class,id);
    }


    @Override
    public boolean add(Project_paket project_paket) {
        persist(project_paket);
        return true;
    }

    @Override
    public boolean edit(Project_paket project_paket) {
        update(project_paket);
        return true;
    }




}
