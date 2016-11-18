package com.arifin.Umum.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by etos on 11/2/2016.
 */
@Entity
@Table(name = "T_KELURAHAN")
public class Kelurahan {
    @Id
    private long id_kel;
    private long id_kec;
    private String nama_kel;


    public long getId_kel() {
        return id_kel;
    }

    public void setId_kel(long id_kel) {
        this.id_kel = id_kel;
    }

    public long getId_kec() {
        return id_kec;
    }

    public void setId_kec(long id_kec) {
        this.id_kec = id_kec;
    }

    public String getNama_kel() {
        return nama_kel;
    }

    public void setNama_kel(String nama_kel) {
        this.nama_kel = nama_kel;
    }
}
