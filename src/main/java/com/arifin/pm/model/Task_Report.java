package com.arifin.pm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Handy on 07/11/2016.
 */



@Entity
@Table (name = "PM_TASK_REPORT")
public class Task_Report implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_TASK_REPORT_SEQ")
    @SequenceGenerator(name="PM_TASK_REPORT_SEQ", sequenceName="PM_TASK_REPORT_SEQ")
    private int id_task_report;
    private int id_task;
    private String report_status;
    private Date report_tanggal;
    private String report_detail;
    private String report_progress;
    private int is_deleted=0;
    private Date tgl_acc;
    private int id_perusahaan_pegawai;

    public Object clone()
    {
        Task_Report report = new Task_Report();
        report.setId_task(this.id_task);
        report.setReport_status(this.report_status);
        report.setReport_tanggal(this.report_tanggal);
        report.setReport_detail(this.report_detail);
        report.setReport_progress(this.report_progress);
        report.setIs_deleted(this.is_deleted);
        report.setTgl_acc(this.tgl_acc);
        report.setId_perusahaan_pegawai(this.id_perusahaan_pegawai);

        return report;
    }

    public int getId_task_report() {
        return id_task_report;
    }

    public void setId_task_report(int id_task_report) {
        this.id_task_report = id_task_report;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public String getReport_status() {
        return report_status;
    }

    public void setReport_status(String report_status) {
        this.report_status = report_status;
    }

    public Date getReport_tanggal() {
        return report_tanggal;
    }

    public void setReport_tanggal(Date report_tanggal) {
        this.report_tanggal = report_tanggal;
    }

    public String getReport_detail() {
        return report_detail;
    }

    public void setReport_detail(String report_detail) {
        this.report_detail = report_detail;
    }

    public String getReport_progress() {
        return report_progress;
    }

    public void setReport_progress(String report_progress) {
        this.report_progress = report_progress;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Date getTgl_acc() {
        return tgl_acc;
    }

    public void setTgl_acc(Date tgl_acc) {
        this.tgl_acc = tgl_acc;
    }

    public int getId_perusahaan_pegawai() {
        return id_perusahaan_pegawai;
    }

    public void setId_perusahaan_pegawai(int id_perusahaan_pegawai) {
        this.id_perusahaan_pegawai = id_perusahaan_pegawai;
    }

}
