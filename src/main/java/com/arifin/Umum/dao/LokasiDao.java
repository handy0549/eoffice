package com.arifin.Umum.dao;

import com.arifin.Umum.model.Kabkot;
import com.arifin.Umum.model.Kecematan;
import com.arifin.Umum.model.Kelurahan;
import com.arifin.Umum.model.Provinsi;
import com.arifin.abstrac.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ojiepermana on 11/18/2016.
 */
@Transactional
@Component
public class LokasiDao extends AbstractDao<Integer,Kabkot> {

    public Kabkot getKabKot(long id)
    {
        Kabkot data = (Kabkot) getSession().get(Kabkot.class,id);

//        Criteria criteria = getSession().createCriteria(Kabkot.class);
//        Kabkot yourObject = (Kabkot) criteria.add(Restrictions.eq("id_kabkot", id))
//                .uniqueResult();

        return data;
    }
    public Kecematan getKecematan(long id)
    {
        Kecematan data = (Kecematan) getSession().get(Kecematan.class,id);
        return data;
    }
    public Kelurahan getKelurahan(long id)
    {
        Kelurahan data = (Kelurahan) getSession().get(Kelurahan.class,id);
        return data;
    }
    public Provinsi getProvinsi(long id)
    {
        Provinsi data = (Provinsi) getSession().get(Provinsi.class,id);
        return data;
    }


}
