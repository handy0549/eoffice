package com.arifin.pm.model;

import javax.persistence.Id;

/**
 * Created by ojiepermana on 11/10/2016.
 */
public class Project_paket {
    @Id
    private int id_project_paket;
    private String nama_paket;
    private  String keterangan;
    private int induk;

}
