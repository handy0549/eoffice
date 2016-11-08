package com.arifin.pm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Handy on 07/11/2016.
 */



@Entity
@Table (name = "PM_TASK_TEAM")
public class Task_Team implements Serializable {


    @Id
    private int id_task_team;
    private int id_task;
    private int id_perusahaan_pegawai;
    private String team_status;

}
