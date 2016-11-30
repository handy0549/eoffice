package com.arifin.pm.dao.project;

import com.arifin.abstrac.AbstractDao;
import com.arifin.helper.ToSql;
import com.arifin.pm.model.Project;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by ojiepermana on 11/10/2016.
 */
@Transactional
@Repository("ProjectDaoImp")
public class ProjectDaoImp extends AbstractDao<Integer,Project> implements ProjectDao   {

    @Autowired
    ToSql toSql;

    @Override
    public List  getAll(Map<String,String > param, Boolean page) {
         String Sql = "Select  ROWNUM rn," +
                 "a.*, " +
                 "b.nama_kel," +
                 "c.nama_kec," +
                 "d.nama_kabkot," +
                 "e.nama_prov," +
                 "" +
                 "f.nama_paket, " +
                 "g.project_jenis, " +
                 "x.nama_perusahaan as kontraktor, " +
                 "y.nama_perusahaan as supervisi " +

                 " from pm_project a, "+
                 "t_kelurahan b, " +
                 "t_kecamatan c, " +
                 "t_kabkot d, " +
                 "t_provinsi e, " +

                 "pm_project_paket f, " +
                 "pm_project_jenis g," +
                 "pm_perusahaan x," +
                 "pm_perusahaan y " +

                 "where  a.id_kel=b.id_kel "  +
                 "and a.id_kec = c.id_kec " +
                 "and a.id_kabkot=d.id_kabkot "   +
                 "and a.id_prov = e.id_prov " +

                 "and a.id_project_paket = f.id_project_paket " +
                 "and a.id_project_jenis = g.id_project_jenis " +
                 "and a.id_kontraktor =x.id_perusahaan " +
                 "and a.id_supervisi = y.id_perusahaan ";

        Sql=toSql.Where(Sql, param,"a", page);
        Sql+=" ORDER  BY a.id_project DESC ";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();

        return rows;
    }

    @Override
    public boolean create(Project project) {
         if(persist(project))
         {
            return true;
         }
         return false;
    }

    @Override
    public boolean update(int id, Project project) {
        if(update(project))
        {
            return true;
        }
        return false;
    }

    public Object detail(int id)
    {
        String Sql = "Select  ROWNUM rn," +
                "a.*, " +
                "b.nama_kel," +
                "c.nama_kec," +
                "d.nama_kabkot," +
                "e.nama_prov," +

                "f.NAMA_PAKET , " +
                "f.KETERANGAN_PAKET , " +
                "f.INDUK_PAKET , " +
                "f.TAHUN_ANGGARAN_PAKET , " +
                "f.PAGU_ANGGARAN_PAKET , " +
                "f.NILAI_KONTRAK , " +
                "f.NO_KONTRAK , " +
                "f.TGL_KONTRAK , " +
                "f.PPK , " +
                "f.ID_KONTRAKTOR_PAKET , " +
                "f.ID_SUPERVISI_PAKET, " +

                "g.project_jenis, " +
                "x.nama_perusahaan as kontraktor, " +
                "y.nama_perusahaan as supervisi " +

                " from pm_project a, "+
                "t_kelurahan b, " +
                "t_kecamatan c, " +
                "t_kabkot d, " +
                "t_provinsi e, " +

                "pm_project_paket f, " +
                "pm_project_jenis g," +
                "pm_perusahaan x," +
                "pm_perusahaan y " +

                "where  a.id_kel=b.id_kel "  +
                "and a.id_kec = c.id_kec " +
                "and a.id_kabkot=d.id_kabkot "   +
                "and a.id_prov = e.id_prov " +

                "and a.id_project_paket = f.id_project_paket " +
                "and a.id_project_jenis = g.id_project_jenis " +
                "and a.id_kontraktor =x.id_perusahaan " +
                "and a.id_supervisi = y.id_perusahaan " +
                "and a.id_project=" + id +" ";



        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        return query.uniqueResult();
    }

    @Override
    public Project detailLite(int id) {
        return (Project) getSession().get(Project.class,id);
    }



    //TOOOLSS>>>>>>>>>>>>>>>>>>>>>
    @Override
    public Object getProjectPerusahaan(int id_project) {
        String Sql = "SELECT\n" +
                " a.NAMA_PROJECT, " +
                "a.ID_PROJECT ," +
                "  x.NAMA_PERUSAHAAN as k_NAMA_PERUSAHAAN ,\n" +
                "  x.DIREKTUR_PERUSAHAAN as k_DIREKTUR_PERUSAHAAN,\n" +
                "  x.EMAIL_PERUSAHAAN as k_EMAIL_PERUSAHAAN,\n" +
                "  x.TELFON_PERUSAHAAN as k_TELFON_PERUSAHAAN,\n" +
                "  x.ALAMAT_PERUSAHAAN as k_ALAMAT_PERUSAHAAN ,\n" +
                "\n" +
                "  y.NAMA_PERUSAHAAN as s_NAMA_PERUSAHAAN,\n" +
                "  y.DIREKTUR_PERUSAHAAN as s_DIREKTUR_PERUSAHAAN ,\n" +
                "  y.EMAIL_PERUSAHAAN as s_EMAIL_PERUSAHAAN,\n" +
                "  y.TELFON_PERUSAHAAN as s_TELFON_PERUSAHAAN,\n" +
                "  y.ALAMAT_PERUSAHAAN as s_ALAMAT_PERUSAHAAN\n" +
                "\n" +
                "FROM PM_PROJECT a,\n" +
                "  PM_MODUL b,\n" +
                "  PM_TASK c,\n" +
                "PM_PERUSAHAAN x,\n" +
                "  PM_PERUSAHAAN y\n" +
                "\n" +
                "WHERE a.ID_PROJECT=b.ID_PROJECT\n" +
                "  and b.ID_MODUL=c.ID_MODUL\n" +
                "  and a.ID_KONTRAKTOR=x.ID_PERUSAHAAN\n" +
                "and a.ID_SUPERVISI=y.ID_PERUSAHAAN\n" +
                "\n" +
                "and c.ID_TASK="+ id_project +" ";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        return query.uniqueResult();
    }
}
