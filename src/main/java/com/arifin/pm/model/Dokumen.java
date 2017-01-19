package com.arifin.pm.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Handy on 07/11/2016.
 */


 @Entity
 @Table(name = "PM_DOKUMEN")
public class Dokumen implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_DOKUMEN_SEQ")
    @SequenceGenerator(name="PM_DOKUMEN_SEQ", sequenceName="PM_DOKUMEN_SEQ")
    private int id_dokumen;
    private String jenis_dokumen;
    private int dokumen_untuk;
    private String dokumen;
    private String keterangan;
    private String lokasi_file;
    private String jenis_file;
    private String nama_file;
    private String nomor;
    private Date tgl_upload;
    private int id_param;



    public int getId_dokumen() {
        return id_dokumen;
    }

    public void setId_dokumen(int id_dokumen) {
        this.id_dokumen = id_dokumen;
    }

    public String getJenis_dokumen() {
        return jenis_dokumen;
    }

    public void setJenis_dokumen(String jenis_dokumen) {
        this.jenis_dokumen = jenis_dokumen;
    }

    public int getDokumen_untuk() {
        return dokumen_untuk;
    }

    public void setDokumen_untuk(int dokumen_untuk) {
        this.dokumen_untuk = dokumen_untuk;
    }

    public String getDokumen() {
        return dokumen;
    }

    public void setDokumen(String dokumen) {
        this.dokumen = dokumen;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLokasi_file() {
        return lokasi_file;
    }

    public void setLokasi_file(String lokasi_file) {
        this.lokasi_file = lokasi_file;
    }

    public String getJenis_file() {
        return jenis_file;
    }

    public void setJenis_file(String jenis_file) {
        this.jenis_file = jenis_file;
    }

    public String getNama_file() {
        return nama_file;
    }

    public void setNama_file(String nama_file) {
        this.nama_file = nama_file;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Date getTgl_upload() {
        return tgl_upload;
    }

    public void setTgl_upload(Date tgl_upload) {
        this.tgl_upload = tgl_upload;
    }

    public int getId_param() {
        return id_param;
    }

    public void setId_param(int id_param) {
        this.id_param = id_param;
    }
}
