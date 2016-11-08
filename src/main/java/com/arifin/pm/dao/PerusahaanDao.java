package com.arifin.pm.dao;

import com.arifin.pm.model.Perusahaan;

import java.util.List;

/**
 * Created by etos on 11/2/2016.
 */
public interface PerusahaanDao {
    List<java.lang.Object[]> getAll();
    void create(Perusahaan perusahaan);
}
