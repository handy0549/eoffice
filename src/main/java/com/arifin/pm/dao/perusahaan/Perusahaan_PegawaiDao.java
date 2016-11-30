package com.arifin.pm.dao.perusahaan;

import com.arifin.pm.model.Perusahaan_Pegawai;

import java.util.List;

/**
 * Created by Handy on 09/11/2016.
 */
public interface Perusahaan_PegawaiDao {
    List getAll(int id);
    List getAllLite(int id);
    boolean addPegawai(Perusahaan_Pegawai perusahaan_pegawai);
    Perusahaan_Pegawai getDetailPegawai(int id);
    boolean editPegawai(Perusahaan_Pegawai pegawai);
}
