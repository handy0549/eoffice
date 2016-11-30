package com.arifin.pm.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by etos on 11/28/2016.
 */
@Entity
@Table(name = "PM_PROJECT_CAIR", schema = "EOFFICE", catalog = "")
public class Project_cair {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PM_PROJECT_CAIR_SEQ")
    @SequenceGenerator(name="PM_PROJECT_CAIR_SEQ", sequenceName="PM_PROJECT_CAIR_SEQ")

    private int id_cair;
    private int pencairan_ke;
    private long jumlah_cair;
    private float progress = 0;
    private float realisasi_progress = 0;
    private long realisasi_cair;
    private Date realisasi_tanggal;
    private int is_deleted=0;
    private int id_user;
    private String keterangan;
    private Date rencana_tanggal;
    private int id_project;


    public int getId_cair() {
        return id_cair;
    }

    public void setId_cair(int id_cair) {
        this.id_cair = id_cair;
    }

    public int getPencairan_ke() {
        return pencairan_ke;
    }

    public void setPencairan_ke(int pencairan_ke) {
        this.pencairan_ke = pencairan_ke;
    }

    public long getJumlah_cair() {
        return jumlah_cair;
    }

    public void setJumlah_cair(long jumlah_cair) {
        this.jumlah_cair = jumlah_cair;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public float getRealisasi_progress() {
        return realisasi_progress;
    }

    public void setRealisasi_progress(float realisasi_progress) {
        this.realisasi_progress = realisasi_progress;
    }

    public long getRealisasi_cair() {
        return realisasi_cair;
    }

    public void setRealisasi_cair(long realisasi_cair) {
        this.realisasi_cair = realisasi_cair;
    }

    public Date getRealisasi_tanggal() {
        return realisasi_tanggal;
    }

    public void setRealisasi_tanggal(Date realisasi_tanggal) {
        this.realisasi_tanggal = realisasi_tanggal;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getRencana_tanggal() {
        return rencana_tanggal;
    }

    public void setRencana_tanggal(Date rencana_tanggal) {
        this.rencana_tanggal = rencana_tanggal;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }
}
