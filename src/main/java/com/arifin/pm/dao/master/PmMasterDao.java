package com.arifin.pm.dao.master;

import com.arifin.pm.model.Perusahaam_kategori;
import com.arifin.pm.model.Project_jenis;

import java.util.List;

/**
 * Created by ojiepermana on 11/15/2016.
 */
public interface PmMasterDao {

    List<Perusahaam_kategori> listPerusahaanKategori();
    List<Project_jenis> listProjectJenis();
}
