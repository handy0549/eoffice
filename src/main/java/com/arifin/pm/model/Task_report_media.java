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
    private String jenis_file;
    private Date tgl_upload;
    private String note;
    private String filenyo;

    public Object clone()
    {
        Task_report_media media = new Task_report_media();
        media.setId_task_report(this.id_task_report);
        media.setNama_file(this.nama_file);
        media.setTipe(this.tipe);
        media.setJenis_file(this.jenis_file);
        media.setNote(this.note);
        media.setFilenyo("");

        return media;
    }


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



    public Date getTgl_upload() {
        return tgl_upload;
    }

    public void setTgl_upload(Date tgl_upload) {
        this.tgl_upload = tgl_upload;
    }



    public int getId_task_report() {
        return id_task_report;
    }

    public void setId_task_report(int id_task_report) {
        this.id_task_report = id_task_report;
    }

    public String getJenis_file() {
        return jenis_file;
    }

    public void setJenis_file(String jenis_file) {
        this.jenis_file = jenis_file;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFilenyo() {
        return filenyo;
    }

    public void setFilenyo(String filenyo) {
        this.filenyo = filenyo;
    }
}
