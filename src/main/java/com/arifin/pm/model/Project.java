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
@Table (name = "PROJECT")
public class Project implements Serializable {


    @Id
    private int id_project;
    private int id_kontraktor;
    private int id_supervisi;
    private int id_owner;
    private int id_user;
    private Date tanggal_mulai;
    private Date tanggal_selesai;
    private Date batas_waktu;
    private long id_penanggung_jawab;
    private String lokasi_project;
    private String id_project_jenis;
    private String id_project_paket;
    private String anggaran_pagu;
    private String anggaran_nilai;
    private String lon;
    private String lat;
    private int id_kec;
    private int id_kel;
    private int id_kabkot;
    private int id_prov;
    private String status_project;
    private long progres_project;

    private String sumber_anggaran;
    private long pagu_anggaran;
    private Date created_at;


}
