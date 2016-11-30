package com.arifin.pm.model;

import javax.persistence.*;

/**
 * Created by ojiepermana on 11/25/2016.
 */
@Entity
@Table(name = "PM_PROJECT_LOKASI")
public class Project_lokasi {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_PROJECT_LOKASI_SEQ")
    @SequenceGenerator(name="PM_PROJECT_LOKASI_SEQ", sequenceName="PM_PROJECT_LOKASI_SEQ")
    private int id_lokasi;
    private int id_project;
    private long id_kec;
    private long id_kel;
    private String keterangan;
    private double lon;
    private double lat;


    public int getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(int id_lokasi) {
        this.id_lokasi = id_lokasi;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public long getId_kec() {
        return id_kec;
    }

    public void setId_kec(long id_kec) {
        this.id_kec = id_kec;
    }

    public long getId_kel() {
        return id_kel;
    }

    public void setId_kel(long id_kel) {
        this.id_kel = id_kel;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
