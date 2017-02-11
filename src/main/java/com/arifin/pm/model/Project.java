package com.arifin.pm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Handy on 07/11/2016.
 */


@Entity
@Table (name = "PM_PROJECT")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PM_PROJECT_SEQ")
    @SequenceGenerator(name="PM_PROJECT_SEQ", sequenceName="PM_PROJECT_SEQ")

    private int id_project;
    private int id_kontraktor;
    private int id_supervisi;
    private int id_owner;
    private int id_user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggal_mulai;
    private Date tanggal_selesai;
    private Date batas_waktu;
    private long id_penanggung_jawab;
    private String lokasi_project;
    private int id_project_jenis;
    private int id_project_paket;
    private String nama_project;
    private String anggaran_nilai;
    private String lon;
    private String lat;
    private String id_kec;
    private String id_kel;
    private String id_kabkot;
    private String id_prov;
    private String status_project="progress";
    private float progres_project=0;
    private String sumber_anggaran;
    private long pagu_anggaran;
    private Date created_at;
    private int is_addendum=0;
    private int is_lock=0;

    public Object clone()
    {
        Project obj = new Project();
        obj.setId_kontraktor(this.id_kontraktor);
        obj.setId_supervisi(this.id_supervisi);
        obj.setId_owner(this.id_owner);
        obj.setId_user(this.id_user);
        obj.setTanggal_mulai(this.tanggal_mulai);
        obj.setTanggal_selesai(this.tanggal_selesai);
        obj.setBatas_waktu(this.batas_waktu);
        obj.setId_penanggung_jawab(this.id_penanggung_jawab);
        obj.setLokasi_project(this.lokasi_project);
        obj.setId_project_jenis(this.id_project_jenis);
        obj.setId_project_paket(this.id_project_paket);
        obj.setNama_project(this.nama_project);
        obj.setAnggaran_nilai(this.anggaran_nilai);
        obj.setLon(this.lon);
        obj.setLat(this.lat);
        obj.setId_kec(this.id_kec);
        obj.setId_kel(this.id_kel);
        obj.setId_kabkot(this.id_kabkot);
        obj.setId_prov(this.id_prov);
        obj.setStatus_project(this.status_project);
        obj.setProgres_project(progres_project);
        obj.setSumber_anggaran(this.sumber_anggaran);
        obj.setPagu_anggaran(this.pagu_anggaran);
        obj.setCreated_at(this.created_at);

        return obj;
    }


    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public int getId_kontraktor() {
        return id_kontraktor;
    }

    public void setId_kontraktor(int id_kontraktor) {
        this.id_kontraktor = id_kontraktor;
    }

    public int getId_supervisi() {
        return id_supervisi;
    }

    public void setId_supervisi(int id_supervisi) {
        this.id_supervisi = id_supervisi;
    }

    public int getId_owner() {
        return id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(Date tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public Date getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(Date tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

    public Date getBatas_waktu() {
        return batas_waktu;
    }

    public void setBatas_waktu(Date batas_waktu) {
        this.batas_waktu = batas_waktu;
    }

    public long getId_penanggung_jawab() {
        return id_penanggung_jawab;
    }

    public void setId_penanggung_jawab(long id_penanggung_jawab) {
        this.id_penanggung_jawab = id_penanggung_jawab;
    }

    public String getLokasi_project() {
        return lokasi_project;
    }

    public void setLokasi_project(String lokasi_project) {
        this.lokasi_project = lokasi_project;
    }

    public int getId_project_jenis() {
        return id_project_jenis;
    }

    public void setId_project_jenis(int id_project_jenis) {
        this.id_project_jenis = id_project_jenis;
    }

    public int getId_project_paket() {
        return id_project_paket;
    }

    public void setId_project_paket(int id_project_paket) {
        this.id_project_paket = id_project_paket;
    }

    public String getNama_project() {
        return nama_project;
    }

    public void setNama_project(String nama_project) {
        this.nama_project = nama_project;
    }

    public String getAnggaran_nilai() {
        return anggaran_nilai;
    }

    public void setAnggaran_nilai(String anggaran_nilai) {
        this.anggaran_nilai = anggaran_nilai;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getId_kec() {
        return id_kec;
    }

    public void setId_kec(String id_kec) {
        this.id_kec = id_kec;
    }

    public String getId_kel() {
        return id_kel;
    }

    public void setId_kel(String id_kel) {
        this.id_kel = id_kel;
    }

    public String getId_kabkot() {
        return id_kabkot;
    }

    public void setId_kabkot(String id_kabkot) {
        this.id_kabkot = id_kabkot;
    }

    public String getId_prov() {
        return id_prov;
    }

    public void setId_prov(String id_prov) {
        this.id_prov = id_prov;
    }

    public String getStatus_project() {
        return status_project;
    }

    public void setStatus_project(String status_project) {
        this.status_project = status_project;
    }

    public float getProgres_project() {
        return progres_project;
    }

    public void setProgres_project(float progres_project) {
        this.progres_project = progres_project;
    }

    public String getSumber_anggaran() {
        return sumber_anggaran;
    }

    public void setSumber_anggaran(String sumber_anggaran) {
        this.sumber_anggaran = sumber_anggaran;
    }

    public long getPagu_anggaran() {
        return pagu_anggaran;
    }

    public void setPagu_anggaran(long pagu_anggaran) {
        this.pagu_anggaran = pagu_anggaran;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }


    public int getIs_addendum() {
        return is_addendum;
    }

    public void setIs_addendum(int is_addendum) {
        this.is_addendum = is_addendum;
    }

    public int getIs_lock() {
        return is_lock;
    }

    public void setIs_lock(int is_lock) {
        this.is_lock = is_lock;
    }
}
