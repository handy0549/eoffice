package com.arifin.pm.model;

import javax.persistence.Id;

/**
 * Created by ojiepermana on 11/10/2016.
 */
public class Project_jenis {
    @Id
    private int id_project_jenis;
    private String project_jenis;
    private  String keterangan;


    public int getId_project_jenis() {
        return id_project_jenis;
    }

    public void setId_project_jenis(int id_project_jenis) {
        this.id_project_jenis = id_project_jenis;
    }

    public String getProject_jenis() {
        return project_jenis;
    }

    public void setProject_jenis(String project_jenis) {
        this.project_jenis = project_jenis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
