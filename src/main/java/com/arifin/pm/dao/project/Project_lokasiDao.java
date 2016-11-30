package com.arifin.pm.dao.project;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Project;
import com.arifin.pm.model.Project_lokasi;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 11/25/2016.
 */
@Transactional
@Component
public class Project_lokasiDao extends AbstractDao<Integer,Project_lokasi>{

    public List getAll(int id_project)
    {
        String Sql=  "SELECT\n" +
                "  a.*,\n" +
                "  b.NAMA_KEC,\n" +
                "  c.NAMA_KEL\n" +
                "  FROM PM_PROJECT_LOKASI a,\n" +
                "    T_KECAMATAN b,\n" +
                "    T_KELURAHAN c\n" +
                "WHERE a.ID_KEC=b.ID_KEC\n" +
                "and a.ID_KEL=c.ID_KEL\n" +
                "and a.ID_PROJECT="+ id_project +" ";
        SQLQuery query = getSession().createSQLQuery(Sql);
                query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();
        return rows;
    }

    public Project_lokasi getDetailLite(int id_lokasi)
    {
        Project_lokasi lokasi = (Project_lokasi) getSession().get(Project_lokasi.class,id_lokasi);
        return lokasi;
    }

    public boolean add(Project_lokasi lokasi)
    {
        persist(lokasi);
        return true;
    }
    public boolean edit(Project_lokasi lokasi)
    {
        update(lokasi);
        return true;
    }
}
