package com.arifin.pm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ojiepermana on 2/3/2017.
 */
@Entity
@Table(name = "PM_ADDENDUM")
public class Addendum {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PM_ADDENDUM_SEQ")
    @SequenceGenerator(name="PM_ADDENDUM_SEQ", sequenceName="PM_ADDENDUM_SEQ")
    private int id_addendum;
    private int id_project;
    private int addendum_ke;
    private String nomor_addendum;
    private Date tanggal_addendum;
    private Date tanggal_acc_addendum;
    private String keterangan_addendum;
    private int id_user=1;
    private int is_deleted=0;
    private int id_child_project=0;


    public int getId_addendum() {
        return id_addendum;
    }

    public void setId_addendum(int id_addendum) {
        this.id_addendum = id_addendum;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public int getAddendum_ke() {
        return addendum_ke;
    }

    public void setAddendum_ke(int addendum_ke) {
        this.addendum_ke = addendum_ke;
    }

    public String getNomor_addendum() {
        return nomor_addendum;
    }

    public void setNomor_addendum(String nomor_addendum) {
        this.nomor_addendum = nomor_addendum;
    }

    public Date getTanggal_addendum() {
        return tanggal_addendum;
    }

    public void setTanggal_addendum(Date tanggal_addendum) {
        this.tanggal_addendum = tanggal_addendum;
    }

    public Date getTanggal_acc_addendum() {
        return tanggal_acc_addendum;
    }

    public void setTanggal_acc_addendum(Date tanggal_acc_addendum) {
        this.tanggal_acc_addendum = tanggal_acc_addendum;
    }

    public String getKeterangan_addendum() {
        return keterangan_addendum;
    }

    public void setKeterangan_addendum(String keterangan_addendum) {
        this.keterangan_addendum = keterangan_addendum;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }


    public int getId_child_project() {
        return id_child_project;
    }

    public void setId_child_project(int id_child_project) {
        this.id_child_project = id_child_project;
    }
}
