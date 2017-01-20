package com.arifin.pm.controller;


import com.arifin.Umum.dao.FileValidator;
import com.arifin.Umum.dao.MultiFileValidator;
import com.arifin.Umum.model.FileBucket;
import com.arifin.pm.dao.DokumenDao;
import com.arifin.pm.model.Dokumen;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @GetMapping("/download/{id_dokumen}")
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable("id_dokumen") int id_dokumen)
    {

        Dokumen dokumen = dokumenDao.getById(id_dokumen);
        String fileName = dokumen.getNama_file();
        String dataDirectory = context.getRealPath("") + "/Document/";

        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file))
        {
            response.setContentType("application/" + dokumen.getJenis_file());
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @PostMapping("/upload")
    public ResponseEntity singleFileUpload(
                @RequestParam("file") MultipartFile file,
                @RequestParam("dokumen") String dokumens

    ) throws IOException {
        String filename = "upload.xlsx";
        if (!file.isEmpty()) {
            try {
                String uploadPath = context.getRealPath("") + "/Document/";
                FileCopyUtils.copy(file.getBytes(), new File(uploadPath + file.getOriginalFilename()));

                String namaFile = file.getOriginalFilename();
                ObjectMapper mapper = new ObjectMapper();
                try {
                    Dokumen dokumen = mapper.readValue(dokumens, Dokumen.class);
                    System.out.println(dokumen.toString());

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

                    return ResponseEntity.ok(document);


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
