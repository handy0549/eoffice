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
    private int id_,modul;
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
    private long nilai_satuan;
    private long jumlah_satuan;
    private String task_progres;
    private Date created_at_task;

}
