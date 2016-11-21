package com.arifin.pm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Handy on 07/11/2016.
 */


@Entity
@Table (name = "PM_PERUSAHAAN_PEGAWAI")
public class Perusahaan_Pegawai implements Serializable{


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_PRUSAHAAN_PEGAWAI_SEQ")
    @SequenceGenerator(name="PM_PRUSAHAAN_PEGAWAI_SEQ", sequenceName="PM_PRUSAHAAN_PEGAWAI_SEQ")
    private int id_perusahaan_pegawai;
    private int id_perusahaan;
    private String nama_pegawai_p;
    private int id_jabatan_p;
    private String jenis_identitas_p;
    private String nomor_identitas_p;
    private String alamat_p;
    private String no_hp_p;
    private String email_p;
    private Date tgl_lahir_p;
    private String tempat_lahir_p;
    private String bagian_bidang_p;
    private String kode_pos_p;
    private String status_perusahaan_p;
    private String nip;


    public int getId_perusahaan_pegawai() {
        return id_perusahaan_pegawai;
    }

    public void setId_perusahaan_pegawai(int id_perusahaan_pegawai) {
        this.id_perusahaan_pegawai = id_perusahaan_pegawai;
    }

    public int getId_perusahaan() {
        return id_perusahaan;
    }

    public void setId_perusahaan(int id_perusahaan) {
        this.id_perusahaan = id_perusahaan;
    }

    public String getNama_pegawai_p() {
        return nama_pegawai_p;
    }

    public void setNama_pegawai_p(String nama_pegawai_p) {
        this.nama_pegawai_p = nama_pegawai_p;
    }

    public int getId_jabatan_p() {
        return id_jabatan_p;
    }

    public void setId_jabatan_p(int id_jabatan_p) {
        if(id_jabatan_p < 1)
        {
            this.id_jabatan_p = 0;
        }
        else
        {
            this.id_jabatan_p = id_jabatan_p;
        }
    }

    public String getJenis_identitas_p() {
        return jenis_identitas_p;
    }

    public void setJenis_identitas_p(String jenis_identitas_p) {
        this.jenis_identitas_p = jenis_identitas_p;
    }

    public String getNomor_identitas_p() {
        return nomor_identitas_p;
    }

    public void setNomor_identitas_p(String nomor_identitas_p) {
        this.nomor_identitas_p = nomor_identitas_p;
    }

    public String getAlamat_p() {
        return alamat_p;
    }

    public void setAlamat_p(String alamat_p) {
        this.alamat_p = alamat_p;
    }

    public String getNo_hp_p() {
        return no_hp_p;
    }

    public void setNo_hp_p(String no_hp_p) {
        this.no_hp_p = no_hp_p;
    }

    public String getEmail_p() {
        return email_p;
    }

    public void setEmail_p(String email_p) {
        this.email_p = email_p;
    }

    public Date getTgl_lahir_p() {
        return tgl_lahir_p;
    }

    public void setTgl_lahir_p(Date tgl_lahir_p) {
        this.tgl_lahir_p = tgl_lahir_p;
    }

    public String getTempat_lahir_p() {
        return tempat_lahir_p;
    }

    public void setTempat_lahir_p(String tempat_lahir_p) {
        this.tempat_lahir_p = tempat_lahir_p;
    }

    public String getB_bidang_p() {
        return bagian_bidang_p;
    }

    public void setB_bidang_p(String b_bidang_p) {
        this.bagian_bidang_p = b_bidang_p;
    }

    public String getKode_pos_p() {
        return kode_pos_p;
    }

    public void setKode_pos_p(String kode_pos_p) {
        this.kode_pos_p = kode_pos_p;
    }

    public String getStatus_perusahaan_p() {
        return status_perusahaan_p;
    }

    public void setStatus_perusahaan_p(String status_perusahaan_p) {
        this.status_perusahaan_p = status_perusahaan_p;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
