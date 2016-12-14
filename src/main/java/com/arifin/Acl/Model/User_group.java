package com.arifin.Acl.Model;

import javax.persistence.*;

/**
 * Created by ojiepermana on 12/1/2016.
 */
@Entity
@Table(name = "USERS_GROUP", schema = "EOFFICE", catalog = "")
public class User_group {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USERS_GROUP_SEQ")
    @SequenceGenerator(name="USERS_GROUP_SEQ", sequenceName="USERS_GROUP_SEQ")
    private int id_group;
    private String nama_group;
    private String keterangan_group;
    private int is_deleted=0;


    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getNama_group() {
        return nama_group;
    }

    public void setNama_group(String nama_group) {
        this.nama_group = nama_group;
    }

    public String getKeterangan_group() {
        return keterangan_group;
    }

    public void setKeterangan_group(String keterangan_group) {
        this.keterangan_group = keterangan_group;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }
}
