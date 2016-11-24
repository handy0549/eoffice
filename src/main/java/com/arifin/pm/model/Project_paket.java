package com.arifin.pm.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ojiepermana on 11/10/2016.
 */
@Entity
@Table(name = "PM_PROJECT_PAKET")
public class Project_paket {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_PROJECT_PAKET_SEQ")
    @SequenceGenerator(name="PM_PROJECT_PAKET_SEQ", sequenceName="PM_PROJECT_PAKET_SEQ")

    private int id_project_paket;
    private String nama_paket;
    private String keterangan_paket;
    private String induk_paket;
    private String tahun_anggaran_paket;
    private Long pagu_anggaran_paket;
    private Long nilai_kontrak;
    private String no_kontrak;

    @Temporal(TemporalType.DATE)
    private Date tgl_kontrak;
    private String ppk;
    private Long id_user;
    private String status_lock="no";

    private int id_kontraktor_paket;
    private  int id_supervisi_paket;

    @Temporal(TemporalType.DATE)
    private Date tgl_created;
//    @Column(nullable = false, columnDefinition = "String default 'no'")
    private String is_deleted="no";

    public int getId_project_paket() {
        return id_project_paket;
    }

    public void setId_project_paket(int id_project_paket) {
        this.id_project_paket = id_project_paket;
    }

    public String getNama_paket() {
        return nama_paket;
    }

    public void setNama_paket(String nama_paket) {
        this.nama_paket = nama_paket;
    }

    public String getKeterangan_paket() {
        return keterangan_paket;
    }

    public void setKeterangan_paket(String keterangan_paket) {
        this.keterangan_paket = keterangan_paket;
    }

    public String getInduk_paket() {
        return induk_paket;
    }

    public void setInduk_paket(String induk_paket) {
        this.induk_paket = induk_paket;
    }

    public String getTahun_anggaran_paket() {
        return tahun_anggaran_paket;
    }

    public void setTahun_anggaran_paket(String tahun_anggaran_paket) {
        this.tahun_anggaran_paket = tahun_anggaran_paket;
    }

    public Long getPagu_anggaran_paket() {
        return pagu_anggaran_paket;
    }

    public void setPagu_anggaran_paket(Long pagu_anggaran_paket) {
        this.pagu_anggaran_paket = pagu_anggaran_paket;
    }

    public Long getNilai_kontrak() {
        return nilai_kontrak;
    }

    public void setNilai_kontrak(Long nilai_kontrak) {
        this.nilai_kontrak = nilai_kontrak;
    }

    public String getNo_kontrak() {
        return no_kontrak;
    }

    public void setNo_kontrak(String No_kontrak) {
        this.no_kontrak = No_kontrak;
    }

    public Date getTgl_kontrak() {
        return tgl_kontrak;
    }

    public void setTgl_kontrak(Date tgl_kontrak) {
        this.tgl_kontrak = tgl_kontrak;
    }

    public String getPpk() {
        return ppk;
    }

    public void setPpk(String ppk) {
        this.ppk = ppk;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getStatus_lock() {
        return status_lock;
    }

    public void setStatus_lock(String status_lock) {
        if (status_lock == null) {
            this.status_lock = "no";
        }
        else
        {
            this.status_lock = status_lock;
        }


    }

    public Date getTgl_created() {
        return tgl_created;
    }

    public void setTgl_created(Date tgl_created) {

        if (tgl_created == null) {
            this.tgl_created = new Date();
        }
        else
        {
            this.tgl_created = tgl_created;
        }
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        if (is_deleted == null) {
            this.is_deleted = "no";
        }
        else
        {
            this.is_deleted = is_deleted;
        }
    }

    public int getId_kontraktor_paket() {
        return id_kontraktor_paket;
    }

    public void setId_kontraktor_paket(int id_kontraktor_paket) {
        this.id_kontraktor_paket = id_kontraktor_paket;
    }

    public int getId_supervisi_paket() {
        return id_supervisi_paket;
    }

    public void setId_supervisi_paket(int id_supervisi_paket) {
        this.id_supervisi_paket = id_supervisi_paket;
    }
}
