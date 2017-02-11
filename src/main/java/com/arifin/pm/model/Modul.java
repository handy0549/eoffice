package com.arifin.pm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Handy on 07/11/2016.
 */


@Entity
@Table (name = "PM_MODUL")
public class Modul implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_MODUL_SEQ")
    @SequenceGenerator(name="PM_MODUL_SEQ", sequenceName="PM_MODUL_SEQ")
    private int id_modul;
    private int id_project;
    private Date created_at_modul;
    private String modul;
    private String modul_desk;
    private Date modul_start;
    private Date modul_end;
    private long modul_progres=0;
    private long modul_penanggung_jawab;
    private int is_deleted=0;
    private long modul_progress_realisasi=0;
    private String modul_jenis;
    private int urutan=0;

    public Object clone()
    {
        Modul modul = new Modul();
        modul.setId_project(this.id_project);
        modul.setCreated_at_modul(this.created_at_modul);
        modul.setModul(this.modul);
        modul.setModul_desk(this.modul_desk);
        modul.setModul_start(this.modul_start);
        modul.setModul_end(this.modul_end);
        modul.setModul_progres(this.modul_progres);
        modul.setModul_progress_realisasi(this.modul_progress_realisasi);
        modul.setIs_deleted(this.is_deleted);
        modul.setModul_jenis(this.modul_jenis);
        modul.setUrutan(this.urutan);

        return modul;
    }


    public int getId_modul() {
        return id_modul;
    }

    public void setId_modul(int id_modul) {
        this.id_modul = id_modul;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public Date getCreated_at_modul() {
        return created_at_modul;
    }

    public void setCreated_at_modul(Date created_at_modul) {
        this.created_at_modul = created_at_modul;
    }

    public String getModul() {
        return modul;
    }

    public void setModul(String modul) {
        this.modul = modul;
    }

    public String getModul_desk() {
        return modul_desk;
    }

    public void setModul_desk(String modul_desk) {
        this.modul_desk = modul_desk;
    }

    public Date getModul_start() {
        return modul_start;
    }

    public void setModul_start(Date modul_start) {
        this.modul_start = modul_start;
    }

    public Date getModul_end() {
        return modul_end;
    }

    public void setModul_end(Date modul_end) {
        this.modul_end = modul_end;
    }

    public long getModul_progres() {
        return modul_progres;
    }

    public void setModul_progres(long modul_progres) {
        this.modul_progres = modul_progres;
    }

    public long getModul_penanggung_jawab() {
        return modul_penanggung_jawab;
    }

    public void setModul_penanggung_jawab(long modul_penanggung_jawab) {
        this.modul_penanggung_jawab = modul_penanggung_jawab;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public long getModul_progress_realisasi() {
        return modul_progress_realisasi;
    }

    public void setModul_progress_realisasi(long modul_progress_realisasi) {
        this.modul_progress_realisasi = modul_progress_realisasi;
    }

    public String getModul_jenis() {
        return modul_jenis;
    }

    public void setModul_jenis(String modul_jenis) {
        this.modul_jenis = modul_jenis;
    }

    public int getUrutan() {
        return urutan;
    }

    public void setUrutan(int urutan) {
        this.urutan = urutan;
    }
}
