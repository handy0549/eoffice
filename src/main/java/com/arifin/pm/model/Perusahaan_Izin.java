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
@Table (name = "PM_PERUSAHAAN_IZIN")
public class Perusahaan_Izin implements Serializable {


    @Id
    private int id_perusahaan_izin;
    private int id_perusahaan;
    private String no_izin;
    private String jenis_izin;
    private Date awal_izin;
    private Date akhir_izin;
    private String no_sk;
    private long restribusi;
    private String peruntukan;
    private Date created_at;
    private int id_dokumen;


    public int getId_perusahaan_izin() {
        return id_perusahaan_izin;
    }

    public void setId_perusahaan_izin(int id_perusahaan_izin) {
        this.id_perusahaan_izin = id_perusahaan_izin;
    }

    public int getId_perusahaan() {
        return id_perusahaan;
    }

    public void setId_perusahaan(int id_perusahaan) {
        this.id_perusahaan = id_perusahaan;
    }

    public String getNo_izin() {
        return no_izin;
    }

    public void setNo_izin(String no_izin) {
        this.no_izin = no_izin;
    }

    public String getJenis_izin() {
        return jenis_izin;
    }

    public void setJenis_izin(String jenis_izin) {
        this.jenis_izin = jenis_izin;
    }

    public Date getAwal_izin() {
        return awal_izin;
    }

    public void setAwal_izin(Date awal_izin) {
        this.awal_izin = awal_izin;
    }

    public Date getAkhir_izin() {
        return akhir_izin;
    }

    public void setAkhir_izin(Date akhir_izin) {
        this.akhir_izin = akhir_izin;
    }

    public String getNo_sk() {
        return no_sk;
    }

    public void setNo_sk(String no_sk) {
        this.no_sk = no_sk;
    }

    public long getRestribusi() {
        return restribusi;
    }

    public void setRestribusi(long restribusi) {
        this.restribusi = restribusi;
    }

    public String getPeruntukan() {
        return peruntukan;
    }

    public void setPeruntukan(String peruntukan) {
        this.peruntukan = peruntukan;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getId_dokumen() {
        return id_dokumen;
    }

    public void setId_dokumen(int id_dokumen) {
        this.id_dokumen = id_dokumen;
    }
}
