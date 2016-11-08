package com.arifin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by etos on 11/2/2016.
 */
@Entity
@Table(name = "t_kabkot")
public class Kabkot implements Serializable {
    @Id
    private long id_kabkot;

    private long id_prov;
    private String nama_kabkot;


    public long getId_kabkot() {
        return id_kabkot;
    }

    public void setId_kabkot(long id_kabkot) {
        this.id_kabkot = id_kabkot;
    }

    public long getId_prov() {
        return id_prov;
    }

    public void setId_prov(long id_prov) {
        this.id_prov = id_prov;
    }

    public String getNama_kabkot() {
        return nama_kabkot;
    }

    public void setNama_kabkot(String nama_kabkot) {
        this.nama_kabkot = nama_kabkot;
    }
}
