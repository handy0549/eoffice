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
@Table (name = "PM_TASK")
public class Task implements Serializable {


    @Id
    private int id_task;
    private int id_modul;
    private int id_user;
    private int induk;
    private Date task_start;
    private Date task_end;
    private String status_task;
    private long prioritas;
    private Date task_selesai;
    private String task;
    private String task_desk;
    private String task_catatan;
    private String task_jenis;
    private long task_auto_update;
    private long task_progress;
    private String task_progress_realisasi;
    private long task_fee;
    private long task_nilai;


    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public int getId_modul() {
        return id_modul;
    }

    public void setId_modul(int id_modul) {
        this.id_modul = id_modul;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getInduk() {
        return induk;
    }

    public void setInduk(int induk) {
        this.induk = induk;
    }

    public Date getTask_start() {
        return task_start;
    }

    public void setTask_start(Date task_start) {
        this.task_start = task_start;
    }

    public Date getTask_end() {
        return task_end;
    }

    public void setTask_end(Date task_end) {
        this.task_end = task_end;
    }

    public String getStatus_task() {
        return status_task;
    }

    public void setStatus_task(String status_task) {
        this.status_task = status_task;
    }

    public long getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(long prioritas) {
        this.prioritas = prioritas;
    }

    public Date getTask_selesai() {
        return task_selesai;
    }

    public void setTask_selesai(Date task_selesai) {
        this.task_selesai = task_selesai;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask_desk() {
        return task_desk;
    }

    public void setTask_desk(String task_desk) {
        this.task_desk = task_desk;
    }

    public String getTask_catatan() {
        return task_catatan;
    }

    public void setTask_catatan(String task_catatan) {
        this.task_catatan = task_catatan;
    }

    public String getTask_jenis() {
        return task_jenis;
    }

    public void setTask_jenis(String task_jenis) {
        this.task_jenis = task_jenis;
    }

    public long getTask_auto_update() {
        return task_auto_update;
    }

    public void setTask_auto_update(long task_auto_update) {
        this.task_auto_update = task_auto_update;
    }

    public long getTask_progress() {
        return task_progress;
    }

    public void setTask_progress(long task_progress) {
        this.task_progress = task_progress;
    }

    public String getTask_progress_realisasi() {
        return task_progress_realisasi;
    }

    public void setTask_progress_realisasi(String task_progress_realisasi) {
        this.task_progress_realisasi = task_progress_realisasi;
    }

    public long getTask_fee() {
        return task_fee;
    }

    public void setTask_fee(long task_fee) {
        this.task_fee = task_fee;
    }

    public long getTask_nilai() {
        return task_nilai;
    }

    public void setTask_nilai(long task_nilai) {
        this.task_nilai = task_nilai;
    }
}

