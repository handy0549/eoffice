package com.arifin.pm.controller;


import com.arifin.Umum.dao.FileValidator;
import com.arifin.Umum.dao.MultiFileValidator;
import com.arifin.Umum.model.FileBucket;
import com.arifin.pm.dao.DokumenDao;
import com.arifin.pm.model.Dokumen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * Created by Handy on 07/11/2016.
 */
@RestController
@RequestMapping("/pm/dokumen")
public class DokumenCont {
    private final Logger LOG = LoggerFactory.getLogger(DokumenCont.class);

    private static String UPLOAD_LOCATION="C:/ARIFIN/";


    @Autowired
    DokumenDao dokumenDao;

    @Autowired
    ServletContext context;


    @GetMapping("/{jenis}/{id_param}")
    public ResponseEntity<List<Dokumen>> getData(@PathVariable("jenis") int jenis, @PathVariable("id_param") int id_param) {

        List<Map<String, Object>> out = new ArrayList<>();
        List<Dokumen> datas = dokumenDao.getList(jenis,id_param);

        return new  ResponseEntity<List<Dokumen>>(datas, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity singleFileUpload(
                @RequestParam("file") MultipartFile file,
                @RequestParam("jenis_dokumen") String jenis_dokumen,
                @RequestParam("dokumen_untuk") Integer dokumen_untuk,
                @RequestParam("id_param") Integer id_param,
                @RequestParam("keterangan") String keterangan,
                @RequestParam("dokumen") String dokumen,
                @RequestParam("nomor") String nomor

    ) throws IOException {
        String filename = "upload.xlsx";
        if (!file.isEmpty()) {
            try {
                String uploadPath = context.getRealPath("") + "/Document/";
                FileCopyUtils.copy(file.getBytes(), new File(uploadPath + file.getOriginalFilename()));

                String namaFile = file.getOriginalFilename();

                //masuan ka DB
                Dokumen document = new Dokumen();
                document.setJenis_dokumen(jenis_dokumen);
                document.setDokumen_untuk(dokumen_untuk);
                document.setId_param(id_param);
                document.setKeterangan(keterangan);
                document.setNomor(nomor);
                document.setDokumen(dokumen);

                document.setNama_file(namaFile);
                document.setLokasi_file(uploadPath);
                document.setTgl_upload(new Date());
                document.setJenis_file(namaFile.split("\\.")[1]);

                //masuan ka db
                dokumenDao.add(document);

                return ResponseEntity.ok(document);

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
