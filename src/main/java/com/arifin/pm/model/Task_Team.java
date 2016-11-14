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


    public int getId_task_team() {
        return id_task_team;
    }

    public void setId_task_team(int id_task_team) {
        this.id_task_team = id_task_team;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public int getId_perusahaan_pegawai() {
        return id_perusahaan_pegawai;
    }

    public void setId_perusahaan_pegawai(int id_perusahaan_pegawai) {
        this.id_perusahaan_pegawai = id_perusahaan_pegawai;
    }

    public String getTeam_status() {
        return team_status;
    }

    public void setTeam_status(String team_status) {
        this.team_status = team_status;
    }
}
