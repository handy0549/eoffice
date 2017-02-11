package com.arifin.pm.dao.project;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Addendum;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 2/3/2017.
 */
@Transactional
@Component
public class AddendumDao extends AbstractDao<Integer,Addendum> {

    public List<Object> getAll()
    {
        String Sql ="SELECT\n" +
                "  a.*,\n" +
                "  b.NAMA_PROJECT,\n" +
                "  b.PAGU_ANGGARAN,\n" +
                "  b.TANGGAL_MULAI,\n" +
                "  b.TANGGAL_SELESAI,\n" +
                "  b.BATAS_WAKTU,\n" +
                "  e.NO_KONTRAK,\n" +
                "  e.NAMA_PAKET,\n" +
                "  e.NILAI_KONTRAK,\n" +
                "\n" +
                "  c.NAMA_PERUSAHAAN as kontraktor,\n" +
                "  d.NAMA_PERUSAHAAN as supervisi,\n" +
                "  x.NAMA_KABKOT,\n" +
                "  y.NAMA_PROV\n" +
                "\n" +
                "  from PM_ADDENDUM a,\n" +
                "    PM_PROJECT b,\n" +
                "    PM_PERUSAHAAN c,\n" +
                "    PM_PERUSAHAAN d,\n" +
                "    PM_PROJECT_PAKET e,\n" +
                "\n" +
                "    T_KABKOT  x,\n" +
                "    T_PROVINSI y\n" +
                "\n" +
                "WHERE a.ID_PROJECT=b.ID_PROJECT\n" +
                "and b.ID_KONTRAKTOR=c.ID_PERUSAHAAN\n" +
                "and b.ID_SUPERVISI=d.ID_PERUSAHAAN\n" +
                "and b.ID_KABKOT=x.ID_KABKOT\n" +
                "and b.ID_PROV=y.ID_PROV\n" +
                "  AND b.ID_PROJECT_PAKET=e.ID_PROJECT_PAKET\n" +
                "and a.IS_DELETED =0\n";
        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    public List<Addendum> getAllLite(int id_project)
    {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("id_project",id_project))
                .addOrder(Order.asc("id_addendum"));
        return criteria.list();
    }

    public boolean Add(Addendum addendum)
    {
        persist(addendum);
        return true;
    }

    public boolean edit(Addendum addendum)
    {
        update(addendum);
        return true;
    }

    public Addendum getLite(int id_addendum)
    {
        return (Addendum) getSession().get(Addendum.class,id_addendum);
    }
}
