package com.arifin.pm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ojiepermana on 11/20/2016.
 */
@Entity
@Table(name = "T_PERUSAHAAN_JABATAN")
public class Perusahaan_jabatan {
    @Id
    private int id_jabatan_p;
    private String jabatan;
    private String induk;

    public int getId_jabatan_p() {
        return id_jabatan_p;
    }

    public void setId_jabatan_p(int id_jabatan_p) {
        this.id_jabatan_p = id_jabatan_p;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getInduk() {
        return induk;
    }

    public void setInduk(String induk) {
        this.induk = induk;
    }
}
