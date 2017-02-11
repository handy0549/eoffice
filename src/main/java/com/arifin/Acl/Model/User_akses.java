package com.arifin.Acl.Model;

import javax.persistence.*;

/**
 * Created by ojiepermana on 12/1/2016.
 */
@Entity
@Table(name = "USERS_AKSES")
public class User_akses {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USERS_AKSES_SEQ")
    @SequenceGenerator(name="USERS_AKSES_SEQ", sequenceName="USERS_AKSES_SEQ")
    private int id_akses;
    private String url;
    private String url_detail;
    private int id_modul;

    public int getId_akses() {
        return id_akses;
    }

    public void setId_akses(int id_akses) {
        this.id_akses = id_akses;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_detail() {
        return url_detail;
    }

    public void setUrl_detail(String url_detail) {
        this.url_detail = url_detail;
    }

    public int getId_modul() {
        return id_modul;
    }

    public void setId_modul(int id_modul) {
        this.id_modul = id_modul;
    }
}
