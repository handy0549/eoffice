package com.arifin.pm.controller;

import com.arifin.pm.dao.task.Task_report_media_dao;
import com.arifin.pm.model.Task_report_media;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;

/**
 * Created by ojiepermana on 11/25/2016.
 */
@RestController
@RequestMapping(value = "/pm/project/task/media")
public class Task_mediaCont {

    @Autowired
    Task_report_media_dao mediaDao;

    private static String UPLOAD_LOCATION="C:/mytemp/";

    @Autowired
    ServletContext context;

    @GetMapping(value = "/{id_task}")
    public ResponseEntity getAll(@PathVariable int id_task)
    {
        List medias = mediaDao.getAlltask(id_task);
        return new ResponseEntity(medias, HttpStatus.OK);
    }

    @GetMapping(value = "/report/{id_task_report}")
    public ResponseEntity getAllperReport(@PathVariable int id_task_report)
    {
        List medias = mediaDao.getAllReport(id_task_report);
        return new ResponseEntity(medias, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody Task_report_media media)
    {

        try
        {
            //This will decode the String which is encoded by using Base64 class
            byte[] imageByte= Base64.getMimeDecoder().decode(media.getFilenyo());

            String dir = UPLOAD_LOCATION + "media/" + media.getId_task_report();
            File file = new File(dir);
            if (!file.exists())
                file.mkdirs();

            String uploadPath = dir  + "/" + media.getNama_file();
            new FileOutputStream(uploadPath).write(imageByte);
            System.out.println("berhasil--------------->");
        }
        catch(Exception e)
        {
            System.out.println("gagal--------------->" + e);
        }

        mediaDao.add(media);
        return ResponseEntity.ok(media);
    }
}
