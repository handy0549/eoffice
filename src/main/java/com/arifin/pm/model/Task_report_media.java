package com.arifin.pm.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ojiepermana on 11/25/2016.
 */
@Entity
@Table(name = "PM_TASK_REPORT_MEDIA")
public class Task_report_media {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_TASK_REPORT_MEDIA_SEQ")
    @SequenceGenerator(name="PM_TASK_REPORT_MEDIA_SEQ", sequenceName="PM_TASK_REPORT_MEDIA_SEQ")
    private int id_media;
    private int id_task_report;
    private String nama_file;
    private String tipe;
    private String file_nyo;
    private Date tgl_upload;
    private String lokasi_file;


    public int getId_media() {
        return id_media;
    }

    public void setId_media(int id_media) {
        this.id_media = id_media;
    }

    public String getNama_file() {
        return nama_file;
    }

    public void setNama_file(String nama_file) {
        this.nama_file = nama_file;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getFile_nyo() {
        return file_nyo;
    }

    public void setFile_nyo(String file_nyo) {
        this.file_nyo = file_nyo;
    }

    public Date getTgl_upload() {
        return tgl_upload;
    }

    public void setTgl_upload(Date tgl_upload) {
        this.tgl_upload = tgl_upload;
    }

    public String getLokasi_file() {
        return lokasi_file;
    }

    public void setLokasi_file(String lokasi_file) {
        this.lokasi_file = lokasi_file;
    }

    public int getId_task_report() {
        return id_task_report;
    }

    public void setId_task_report(int id_task_report) {
        this.id_task_report = id_task_report;
    }
}
