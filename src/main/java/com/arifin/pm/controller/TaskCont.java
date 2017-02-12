package com.arifin.pm.controller;

import com.arifin.helper.ExcelHelp;
import com.arifin.helper.MappingCore;
import com.arifin.pm.PmApp;
import com.arifin.pm.dao.DokumenDao;
import com.arifin.pm.dao.project.ModulDao;
import com.arifin.pm.dao.project.ProjectDao;
import com.arifin.pm.dao.task.TaskDao;
import com.arifin.pm.model.Dokumen;
import com.arifin.pm.model.Modul;
import com.arifin.pm.model.Project;
import com.arifin.pm.model.Task;
import com.arifin.pm.service.ModuleService;
import com.arifin.pm.service.TaskService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Handy on 10/11/2016.
 */
@RestController
@RequestMapping(value = "/pm/project/task")
public class TaskCont {
    private final Logger LOG = LoggerFactory.getLogger(TaskCont.class);

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private ModulDao modulDao;

    @Autowired
    private TaskService taskService;

    @Autowired
    ProjectDao projectDao;

    @Autowired
    ServletContext context;

    @Autowired
    DokumenDao dokumenDao;

    @Autowired
    PmApp app;




    @GetMapping("/{id_project}")
    public ResponseEntity getTaskFilter (@RequestParam Map<String,String> param, @PathVariable int id_project) {

        List tasks = taskDao.getAllProject(param,id_project);
        return new ResponseEntity(tasks, HttpStatus.OK);

    }

    //menampilkan ID#######
    @GetMapping("/detail_id_id/{id_task}")
    public ResponseEntity getAllPreAdd(@PathVariable int id_task)
    {
        Object task= taskDao.getAllPreAdd(id_task);

        if(task !=null)
        {
            return new ResponseEntity(task,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }

    @GetMapping("/detail/{id_task}")
    public ResponseEntity getDetail(@PathVariable int id_task)
    {
        Object task = taskService.getTaskDetail(id_task);

        if(task !=null)
        {
            return new ResponseEntity(task,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }

    @GetMapping("/detail_pre_add/{id_modul}")
    public ResponseEntity getDetailPreAdd(@PathVariable int id_modul)
    {
        Object task= taskDao.detailPreAdd(id_modul);

        if(task !=null)
        {
            return new ResponseEntity(task,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }

    @GetMapping("/detail_lite/{id_task}")
    public ResponseEntity getDetailLite(@PathVariable int id_task)
    {
        Task task= taskDao.detailLite(id_task);

        if(task !=null)
        {
            return new ResponseEntity(task,HttpStatus.OK);
        }
        return new ResponseEntity("Modul tidak ditemukan",HttpStatus.SERVICE_UNAVAILABLE);

    }



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Task task)
    {
        taskDao.create(task);
        return new ResponseEntity(task,HttpStatus.OK);
    }
    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody Task task)
    {
        taskDao.edit(task);
        return new ResponseEntity(task,HttpStatus.OK);
    }

    @PostMapping("/import/{id_project}")
    public ResponseEntity singleFileUpload(
            @PathVariable int id_project,
            @RequestParam("file") MultipartFile file,
            @RequestParam("dokumen") String dokumens

    ) throws IOException {
        String filename = "upload.xlsx";
        if (!file.isEmpty()) {
            try {
                String uploadPath = app.UPLOAD_LOCATION + "/Document/" + id_project + "/";
                File fileLokasi = new File(uploadPath);
                if (!fileLokasi.exists())
                {
                    fileLokasi.mkdirs();
                    System.out.println(uploadPath + "///" );
                }
                FileCopyUtils.copy(file.getBytes(), new File(uploadPath + file.getOriginalFilename()));


                String namaFile = file.getOriginalFilename();
                ObjectMapper mapper = new ObjectMapper();
                try {
                    Dokumen dokumen = mapper.readValue(dokumens, Dokumen.class);

                    //masuan ka DB
                    Dokumen document = new Dokumen();
                    document.setJenis_dokumen(dokumen.getJenis_dokumen());
                    document.setDokumen_untuk(dokumen.getDokumen_untuk());
                    document.setId_param(dokumen.getId_param());
                    document.setKeterangan(dokumen.getKeterangan());
                    document.setNomor(document.getNomor());
                    document.setDokumen(dokumen.getDokumen());

                    document.setNama_file(namaFile);
                    document.setLokasi_file(uploadPath);
                    document.setTgl_upload(new Date());
                    document.setJenis_file(namaFile.split("\\.")[1]);

                    //masuan ka db
                    dokumenDao.add(document);

                    //olah dokument iko ka db
                    if(taskService.importData(id_project,uploadPath + file.getOriginalFilename()))
                    {
                        return ResponseEntity.ok(document);
                    }
                    else
                    {
                        String pesan =  "You failed to proses file, tidak valid ! ";
                        return new ResponseEntity(pesan,HttpStatus.BAD_REQUEST);
                    }


                } catch (JsonParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    return new ResponseEntity(e1,HttpStatus.BAD_REQUEST);
                }




            } catch (Exception e) {
                String pesan =  "You failed to upload " + e.getMessage();
                return new ResponseEntity(pesan,HttpStatus.BAD_REQUEST);
            }


        }
        else {
            String pesan =  "You failed to upload " + filename + " because the file was empty.";
            return new ResponseEntity(pesan,HttpStatus.BAD_REQUEST);
        }
    }


}
