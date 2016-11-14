package com.arifin.pm.model;

import javax.persistence.Id;

/**
 * Created by ojiepermana on 11/10/2016.
 */
public class Project_paket {
    @Id
    private int id_project_paket;
    private String nama_paket;
    private  String keterangan;
    private String induk;


    public int getId_project_paket() {
        return id_project_paket;
    }

    public void setId_project_paket(int id_project_paket) {
        this.id_project_paket = id_project_paket;
    }

    public String getNama_paket() {
        return nama_paket;
    }

    public void setNama_paket(String nama_paket) {
        this.nama_paket = nama_paket;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getInduk() {
        return induk;
    }

    public void setInduk(String induk) {
        this.induk = induk;
    }
}
