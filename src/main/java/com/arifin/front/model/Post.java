package com.arifin.front.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Handy on 07/11/2016.
 */


@Entity
@Table (name = "FN_MODUL")
public class Post implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="S_FN_MODUL")
    @SequenceGenerator(name="S_FN_MODUL", sequenceName="S_FN_MODUL")
    private String id_post;
    private String id_media;
    private String title;
    private String keyword;
    private String content;
    private int id_user;
    private String status="y";
    private int validasi=1;
    private Date created_at;

    public String getId_post() {
        return id_post;
    }

    public void setId_post(String id_post) {
        this.id_post = id_post;
    }

    public String getId_media() {
        return id_media;
    }

    public void setId_media(String id_media) {
        this.id_media = id_media;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getValidasi() {
        return validasi;
    }

    public void setValidasi(int validasi) {
        this.validasi = validasi;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
