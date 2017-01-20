package com.arifin.Umum.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ojiepermana on 1/19/2017.
 */
public class FileBucket {

    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
