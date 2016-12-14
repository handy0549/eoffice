package com.arifin.Acl.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ojiepermana on 12/1/2016.
 */
@Entity
@Table(name = "USERS", schema = "EOFFICE", catalog = "")
@org.hibernate.annotations.Entity(
        dynamicUpdate = true
)

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USERS_SEQ")
    @SequenceGenerator(name="USERS_SEQ", sequenceName="USERS_SEQ")
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String remember_token;
    private Date created_at;
    private Long id_lokasi;
    private Long id_groups;
    private int status=1;
    private String authorities;
    private String jenis;
    private Long id_pegawai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Long getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(Long id_lokasi) {
        this.id_lokasi = id_lokasi;
    }

    public Long getId_groups() {
        return id_groups;
    }

    public void setId_groups(Long id_groups) {
        this.id_groups = id_groups;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Long getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(Long id_pegawai) {
        this.id_pegawai = id_pegawai;
    }
}
