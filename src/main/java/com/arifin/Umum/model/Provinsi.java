package com.arifin.Umum.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by etos on 11/2/2016.
 */
@Entity
@Table(name = "T_PROVINSI")
public class Provinsi {
    @Id
    private long id_prov;
    private String nama_prov;


    public long getId_prov() {
        return id_prov;
    }

    public void setId_prov(long id_prov) {
        this.id_prov = id_prov;
    }

    public String getNama_prov() {
        return nama_prov;
    }

    public void setNama_prov(String nama_prov) {
        this.nama_prov = nama_prov;
    }
}
