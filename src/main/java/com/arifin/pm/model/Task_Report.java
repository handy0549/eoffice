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


}
