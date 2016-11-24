package com.arifin.pm.dao.perusahaan;

import com.arifin.abstrac.AbstractDao;
import com.arifin.Umum.model.Kabkot;
import com.arifin.Umum.model.Kecematan;
import com.arifin.Umum.model.Kelurahan;
import com.arifin.Umum.model.Provinsi;
import com.arifin.pm.model.Perusahaam_kategori;
import com.arifin.pm.model.Perusahaan;
import com.arifin.pm.model.Perusahaan_Pegawai;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by etos on 11/2/2016.
 */
@Repository("PerusahaanDaoImp")
@Transactional
public class PerusahaanDaoImp extends AbstractDao<Integer, Perusahaan> implements PerusahaanDao {

    @SuppressWarnings("unchecked")
    public List<Object[]> getAll() {
        String Sql = "Select {a.*}, {b.*}, {c.*} ,{d.*} ,{e.*},{f.*}" +
//                " a.id_perusahaan ,a.nama_perusahaan,a.alamat_perusahaan,a.email_perusahaan," +
//                "a.telfon_perusahaan,a.direkur_perusahaan,a.id_kec,a.id_kabkot," +
//                "a.id_prov,a.id_kel,c.nama_kec,d.nama_kabkot," +
//                "e.nama_prov,b.nama_kel,a.id_user,a.kode_pos,a.npwp,a.fax,a.web,a.status_perusahaan " +

                " from pm_perusahaan a, "+
                "t_kelurahan b, " +
                "t_kecamatan c, " +
                "t_kabkot d, " +
                "t_provinsi e, " +
                "pm_perusahaan_kategori f " +
                "where  a.id_kel=b.id_kel "  +
                "and a.id_kec = c.id_kec " +
                "and a.id_kabkot=d.id_kabkot "   +
                "and a.id_prov = e.id_prov " +
                "and a.id_perusahaan_kategori=f.id_perusahaan_kategori";

        Query query = getSession().createSQLQuery(Sql)
                .addEntity("a",Perusahaan.class)
                .addEntity("b",Kelurahan.class)
                .addEntity("c",Kecematan.class)
                .addEntity("d",Kabkot.class)
                .addEntity("e",Provinsi.class)
                .addEntity("f", Perusahaam_kategori.class);
        List<Object[]> rows = query.list();

        return rows;
    }

    @Override
    public List<Perusahaan> getLite()
    {
        Criteria criteria = getSession().createCriteria(Perusahaan.class);
        List<Perusahaan> perusahaens =criteria.list();
        return  perusahaens;
    }

    @Override
    public boolean create(Perusahaan perusahaan) {
        if(persist(perusahaan))
        {
            return true;
        }
        return false;
    }



    @Override
    public Object getDetail(int id) {

        String Sql = "Select  ROWNUM rn," +
                "a.*, " +
                "b.nama_kel," +
                "c.nama_kec," +
                "d.nama_kabkot," +
                "e.nama_prov," +
                "x.kategori " +

                " from PM_PERUSAHAAN a, "+
                "t_kelurahan b, " +
                "t_kecamatan c, " +
                "t_kabkot d, " +
                "t_provinsi e, " +
                "PM_PERUSAHAAN_KATEGORI x " +

                "where  a.id_kel=b.id_kel "  +
                "and a.id_kec = c.id_kec " +
                "and a.id_kabkot=d.id_kabkot "   +
                "and a.id_prov = e.id_prov " +
                "and a.id_perusahaan_kategori=x.id_perusahaan_kategori " +
                "and a.id_perusahaan = " + id;

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        return query.uniqueResult();
    }





}
