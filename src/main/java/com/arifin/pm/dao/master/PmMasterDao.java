package com.arifin.pm.dao.master;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Perusahaam_kategori;
import com.arifin.pm.model.Perusahaan_jabatan;
import com.arifin.pm.model.Project_jenis;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 11/15/2016.
 */
@Transactional
@Repository
@Component
public class PmMasterDao extends AbstractDao<Integer,Perusahaam_kategori>  {

    public List<Perusahaam_kategori> listPerusahaanKategori() {
        List<Perusahaam_kategori> list = getSession().createSQLQuery("SELECT * from pm_perusahaan_kategori")
                .addEntity(Perusahaam_kategori.class)
                .list();
        return list;
    }


    public List<Project_jenis> listProjectJenis() {

        List<Project_jenis> list = getSession().createSQLQuery("SELECT * from pm_project_jenis")
                .addEntity(Project_jenis.class)
                .list();
        return list;
    }

    public List<Perusahaan_jabatan> listPerusahaanJabatan() {

        List<Perusahaan_jabatan> list = getSession().createSQLQuery("SELECT * from t_perusahaan_jabatan")
                .addEntity(Perusahaan_jabatan.class)
                .list();
        return list;
    }

}
