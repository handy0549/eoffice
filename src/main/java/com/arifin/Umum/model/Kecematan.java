package com.arifin.Umum.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by etos on 11/2/2016.
 */
@Entity
@Table(name = "T_KECAMATAN")
public class Kecematan {

    @Id
    private long id_kec;
    private long id_kabkot;
    private String nama_kec;


    public long getId_kec() {
        return id_kec;
    }

    public void setId_kec(long id_kec) {
        this.id_kec = id_kec;
    }

    public long getId_kabkot() {
        return id_kabkot;
    }

    public void setId_kabkot(long id_kabkot) {
        this.id_kabkot = id_kabkot;
    }

    public String getNama_kec() {
        return nama_kec;
    }

    public void setNama_kec(String nama_kec) {
        this.nama_kec = nama_kec;
    }
}
