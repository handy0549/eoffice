package com.arifin.pm.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ojiepermana on 11/24/2016.
 */
@Entity
@Table(name = "PM_TASK_CHECK", schema = "EOFFICE", catalog = "")
public class Task_check {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_TASK_CHECK_SEQ")
    @SequenceGenerator(name="PM_TASK_CHECK_SEQ", sequenceName="PM_TASK_CHECK_SEQ")
    private int id_task_check;
    private String task_check;
    private String desk_check;
    private String status_check="open";

    @Temporal(TemporalType.DATE)
    private Date tgl_check;
    private String catatan_check;
    private int is_deleted=0;
    private int id_task;


    public int getId_task_check() {
        return id_task_check;
    }

    public void setId_task_check(int id_task_check) {
        this.id_task_check = id_task_check;
    }

    public String getTask_check() {
        return task_check;
    }

    public void setTask_check(String task_check) {
        this.task_check = task_check;
    }

    public String getDesk_check() {
        return desk_check;
    }

    public void setDesk_check(String desk_check) {
        this.desk_check = desk_check;
    }

    public String getStatus_check() {
        return status_check;
    }

    public void setStatus_check(String status_check) {
        this.status_check = status_check;
    }

    public Date getTgl_check() {
        return tgl_check;
    }

    public void setTgl_check(Date tgl_check) {
        this.tgl_check = tgl_check;
    }

    public String getCatatan_check() {
        return catatan_check;
    }

    public void setCatatan_check(String catatan_check) {
        this.catatan_check = catatan_check;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }
}
