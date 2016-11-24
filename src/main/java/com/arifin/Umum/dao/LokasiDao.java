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

import java.util.List;

/**
 * Created by ojiepermana on 11/18/2016.
 */
@Transactional
@Component("LokasiDao")
public class LokasiDao extends AbstractDao<Integer,Kabkot> {

    public List allProv()
    {
        List list =  getSession().createSQLQuery("select * from t_provinsi").addEntity(Provinsi.class).list();
        return  list;
    }

    public List allKabkot(long id)
    {
        List list =  getSession().createSQLQuery("select * from t_kabkot where ID_PROV=" + id).addEntity(Kabkot.class).list();
        return  list;
    }
    public List allKecematan(long id)
    {
        List list =  getSession().createSQLQuery("select * from t_kecamatan where id_kabkot=" + id).addEntity(Kecematan.class).list();
        return  list;
    }
    public List allKelurahan(long id)
    {
        List list =  getSession().createSQLQuery("select * from t_kelurahan where id_kec=" + id).addEntity(Kelurahan.class).list();
        return  list;
    }

    public Kabkot getKabKot(long id)
    {
        Kabkot data = (Kabkot) getSession().get(Kabkot.class,id);
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
