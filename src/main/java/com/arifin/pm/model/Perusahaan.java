package com.arifin.pm.model;


import com.arifin.model.Kecematan;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by etos on 11/2/2016.
 */
@Entity
@Table(name = "PM_PERUSAHAAN")
public class Perusahaan implements Serializable {

    @Id
    private int id_perusahaan;

    private String nama_perusahaan;
    private String alamat_perusahaan;
    private String email_perusahaan;
    private String telfon_perusahaan;
    private String direkur_perusahaan;

    private int id_kec;
    private int id_kabkot;
    private int id_prov;
    private  long id_kel;

    private int id_user;
    private String  kode_pos;
    private String npwp;
    private String fax;
    private String web;
    private String status_perusahaan;


    @Temporal(TemporalType.DATE)
    @Column(name="CREATED_AT")
    private Date createdAt;



    public String getNama_perusahaan() {
        return nama_perusahaan;
    }

    public void setNama_perusahaan(String nama_perusahaan) {
        this.nama_perusahaan = nama_perusahaan;
    }

    public String getAlamat_perusahaan() {
        return alamat_perusahaan;
    }

    public void setAlamat_perusahaan(String alamat_perusahaan) {
        this.alamat_perusahaan = alamat_perusahaan;
    }

    public String getEmail_perusahaan() {
        return email_perusahaan;
    }

    public void setEmail_perusahaan(String email_perusahaan) {
        this.email_perusahaan = email_perusahaan;
    }

    public String getTelfon_perusahaan() {
        return telfon_perusahaan;
    }

    public void setTelfon_perusahaan(String telfon_perusahaan) {
        this.telfon_perusahaan = telfon_perusahaan;
    }

    public String getDirekur_perusahaan() {
        return direkur_perusahaan;
    }

    public void setDirekur_perusahaan(String direkur_perusahaan) {
        this.direkur_perusahaan = direkur_perusahaan;
    }

    public int getId_kec() {
        return id_kec;
    }

    public void setId_kec(int id_kec) {
        this.id_kec = id_kec;
    }

    public int getId_kabkot() {
        return id_kabkot;
    }

    public void setId_kabkot(int id_kabkot) {
        this.id_kabkot = id_kabkot;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public long getId_kel() {
        return id_kel;
    }

    public void setId_kel(long id_kel) {
        this.id_kel = id_kel;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getStatus_perusahaan() {
        return status_perusahaan;
    }

    public void setStatus_perusahaan(String status_perusahaan) {
        this.status_perusahaan = status_perusahaan;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getId_perusahaan() {
        return id_perusahaan;
    }

    public void setId_perusahaan(int id_perusahaan) {
        this.id_perusahaan = id_perusahaan;
    }
}
