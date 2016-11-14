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
@Table (name = "PM_TASK_REPORT")
public class Task_Report implements Serializable {


    @Id
    private int id_task_report;
    private int id_task;
    private String report_status;
    private Date report_tanggal;
    private String report_detail;


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
}
