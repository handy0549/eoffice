package com.arifin.controller;

import com.arifin.pm.PmApp;
import com.arifin.pm.dao.task.Task_report_media_dao;
import com.arifin.pm.model.Dokumen;
import com.arifin.pm.model.Task_report_media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ojiepermana on 2/1/2017.
 */
@RestController
@RequestMapping(value = "/media")
public class MediaCont  {

    @Autowired
    Task_report_media_dao taskReportMediaDao;
    @Autowired
    ServletContext context;

    private PmApp pmApp;

    @GetMapping("/report/{id_media}")
    public void downloadReport( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable("id_media") int id_media)
    {
        Task_report_media media = taskReportMediaDao.getDetail(id_media);
        if(media !=null)
        {
            String fileName = media.getNama_file();
            String dataDirectory = pmApp.UPLOAD_LOCATION + "media/" + media.getId_task_report() +"/";

            Path file = Paths.get(dataDirectory, fileName);
            if (Files.exists(file))
            {
                response.setContentType("application/" + media.getJenis_file());
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
            else
            {
                String root = pmApp.UPLOAD_LOCATION;
                Path not_fount = Paths.get(root, "404.jpg");

                response.setContentType("application/jpg");
                response.addHeader("Content-Disposition", "attachment; filename=404.jpg");
                try
                {
                    Files.copy(not_fount, response.getOutputStream());
                    response.getOutputStream().flush();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        else
        {
            String root = pmApp.UPLOAD_LOCATION;
            Path not_fount = Paths.get(root, "404.jpg");

            response.setContentType("application/jpg");
            response.addHeader("Content-Disposition", "attachment; filename=404.jpg");
            try
            {
                Files.copy(not_fount, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
