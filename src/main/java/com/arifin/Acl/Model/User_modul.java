package com.arifin.Acl.Model;

import javax.persistence.*;

/**
 * Created by ojiepermana on 12/2/2016.
 */
@Entity
@Table(name = "USERS_MODUL", schema = "EOFFICE", catalog = "")
public class User_modul {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USERS_MODUL_SEQ")
    @SequenceGenerator(name="USERS_MODUL_SEQ", sequenceName="USERS_MODUL_SEQ")
    private int id_modul;
    private String modul;
    private String keterangan_modul;


    public int getId_modul() {
        return id_modul;
    }

    public void setId_modul(int id_modul) {
        this.id_modul = id_modul;
    }

    public String getModul() {
        return modul;
    }

    public void setModul(String modul) {
        this.modul = modul;
    }

    public String getKeterangan_modul() {
        return keterangan_modul;
    }

    public void setKeterangan_modul(String keterangan_modul) {
        this.keterangan_modul = keterangan_modul;
    }
}
