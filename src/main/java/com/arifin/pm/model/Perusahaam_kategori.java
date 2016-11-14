package com.arifin.pm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ojiepermana on 11/9/2016.
 */
@Entity
@Table(name = "PM_PERUSAHAAN_KATEGORI")
public class Perusahaam_kategori {
    @Id
    private int id_perusahaan_kategori;

    private String kategori;
    private int status;

    public int getId_perusahaan_kategori() {
        return id_perusahaan_kategori;
    }

    public void setId_perusahaan_kategori(int id_perusahaan_kategori) {
        this.id_perusahaan_kategori = id_perusahaan_kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
