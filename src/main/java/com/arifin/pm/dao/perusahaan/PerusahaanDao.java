package com.arifin.pm.dao.perusahaan;

import com.arifin.pm.model.Perusahaan;
import com.arifin.pm.model.Perusahaan_Pegawai;

import java.util.List;

/**
 * Created by etos on 11/2/2016.
 */
public interface PerusahaanDao {
    List<java.lang.Object[]> getAll();
    List<Perusahaan> getLite();
    Object getDetail(int id);
    boolean create(Perusahaan perusahaan);

}
