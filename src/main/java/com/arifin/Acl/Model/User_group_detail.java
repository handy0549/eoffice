package com.arifin.Acl.Model;

import javax.persistence.*;

/**
 * Created by ojiepermana on 12/1/2016.
 */
@Entity
@Table(name = "USERS_GROUP_DETAIL", schema = "EOFFICE", catalog = "")
public class User_group_detail {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USERS_GROUP_DETAIL_SEQ")
    @SequenceGenerator(name="USERS_GROUP_DETAIL_SEQ", sequenceName="USERS_GROUP_DETAIL_SEQ")
    private int id_group_detail;
    private long id_group;
    private long id_akses;
    private int ubah=1;
    private int tambah=1;


    public int getId_group_detail() {
        return id_group_detail;
    }

    public void setId_group_detail(int id_group_detail) {
        this.id_group_detail = id_group_detail;
    }

    public long getId_group() {
        return id_group;
    }

    public void setId_group(long id_group) {
        this.id_group = id_group;
    }

    public long getId_akses() {
        return id_akses;
    }

    public void setId_akses(long id_akses) {
        this.id_akses = id_akses;
    }

    public int getTambah() {
        return tambah;
    }

    public void setTambah(int tambah) {
        this.tambah = tambah;
    }

    public int getUbah() {
        return ubah;
    }

    public void setUbah(int ubah) {
        this.ubah = ubah;
    }
}
