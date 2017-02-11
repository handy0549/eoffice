package com.arifin.pm.model;

import javax.persistence.*;

/**
 * Created by ojiepermana on 11/9/2016.
 */
@Entity
@Table(name = "PM_PERUSAHAAN_KATEGORI")
public class Perusahaam_kategori {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_PRUSAHAAN_KATEGORI_SEQ")
    @SequenceGenerator(name="PM_PRUSAHAAN_KATEGORI_SEQ", sequenceName="PM_PRUSAHAAN_KATEGORI_SEQ")
    private int id_perusahaan_kategori;
    private String keyword;
    private String kategori;
    private String deskripsi;
    private String status="ok";


    public int getId_perusahaan_kategori() {
        return id_perusahaan_kategori;
    }

    public void setId_perusahaan_kategori(int id_perusahaan_kategori) {
        this.id_perusahaan_kategori = id_perusahaan_kategori;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
