package com.arifin.pm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Handy on 07/11/2016.
 */


@Entity
@Table (name = "PM_MODUL")
public class Modul implements Serializable {


    @Id
    private int id_modul;
    private int id_project;
    private Date created_at_modul;
    private String modul;
    private String modul_desk;
    private Date modul_start;
    private Date modul_end;
    private long modul_progres;
    private long modul_penanggung_jawab;
    private int id_dokumen;
    private String modul_jenis;
    private long modul_auto_update;


    public int getId_modul() {
        return id_modul;
    }

    public void setId_modul(int id_modul) {
        this.id_modul = id_modul;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public Date getCreated_at_modul() {
        return created_at_modul;
    }

    public void setCreated_at_modul(Date created_at_modul) {
        this.created_at_modul = created_at_modul;
    }

    public String getModul() {
        return modul;
    }

    public void setModul(String modul) {
        this.modul = modul;
    }

    public String getModul_desk() {
        return modul_desk;
    }

    public void setModul_desk(String modul_desk) {
        this.modul_desk = modul_desk;
    }

    public Date getModul_start() {
        return modul_start;
    }

    public void setModul_start(Date modul_start) {
        this.modul_start = modul_start;
    }

    public Date getModul_end() {
        return modul_end;
    }

    public void setModul_end(Date modul_end) {
        this.modul_end = modul_end;
    }

    public long getModul_progres() {
        return modul_progres;
    }

    public void setModul_progres(long modul_progres) {
        this.modul_progres = modul_progres;
    }

    public long getModul_penanggung_jawab() {
        return modul_penanggung_jawab;
    }

    public void setModul_penanggung_jawab(long modul_penanggung_jawab) {
        this.modul_penanggung_jawab = modul_penanggung_jawab;
    }

    public int getId_dokumen() {
        return id_dokumen;
    }

    public void setId_dokumen(int id_dokumen) {
        this.id_dokumen = id_dokumen;
    }

    public String getModul_jenis() {
        return modul_jenis;
    }

    public void setModul_jenis(String modul_jenis) {
        this.modul_jenis = modul_jenis;
    }

    public long getModul_auto_update() {
        return modul_auto_update;
    }

    public void setModul_auto_update(long modul_auto_update) {
        this.modul_auto_update = modul_auto_update;
    }
}
