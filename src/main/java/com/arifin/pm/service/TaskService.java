package com.arifin.pm.service;

import com.arifin.helper.ExcelHelp;
import com.arifin.pm.PmApp;
import com.arifin.pm.dao.project.ModulDao;
import com.arifin.pm.dao.project.ProjectDao;
import com.arifin.pm.dao.task.TaskCheckDao;
import com.arifin.pm.dao.task.TaskDao;
import com.arifin.pm.dao.task.Task_ReportDao;
import com.arifin.pm.dao.task.Task_report_media_dao;
import com.arifin.pm.model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by ojiepermana on 11/24/2016.
 */
@Transactional
@Component
public class TaskService {

    @Autowired
    TaskCheckDao taskCheckDao;
    @Autowired
    TaskDao taskDao;
    @Autowired
    Task_ReportDao task_reportDao;
    @Autowired
    ProjectDao projectDao;
    @Autowired
    Task_report_media_dao mediaDao;
    @Autowired
    ModulDao modulDao;
    @Autowired
    PmApp app;

    public Object getTaskDetail(int id_task)
    {
        Task task= taskDao.detailLite(id_task);
        Object check_rangkum = taskCheckDao.getRangkum(id_task);
        Object rekap_report = task_reportDao.getTaskReport(id_task);
        Object perusahaan = projectDao.getProjectPerusahaan(id_task);

        Map<String,Object> map = new HashMap<>();
        map.put("task",task);
        map.put("report_rekap",rekap_report);
        map.put("check_rangkum",check_rangkum);
        map.put("perusahaan",perusahaan);

        return map;
    }
    public Object getDetailLaporan(int id_task_report)
    {
        Object report = task_reportDao.getDetail(id_task_report);
        List<Task_report_media> media = mediaDao.getAllReport(id_task_report);
        Map<String,Object> map = new HashMap<>();

        map.put("report",report);
        map.put("media",media);

        return map;

    }


//    simpan laporan
    public Object addReport(HashMap<String,Map<String,String>> param)
    {
        //insert report
        if(task_reportDao.add(param.get("laporan")))
        {
            //update task
            Task task = task_reportDao.upDateTask(param.get("laporan"));
            if(task !=null)
            {
                Modul modul = modulDao.upDateModul(task);
                if(modul !=null)
                {
                    projectDao.UpdateTaskProject(modul);
                }
            }
        }




        //insert media



        //update project

        return false;
    }

    public Task_Report addReportLite(Task_Report param)
    {
        //insert report
        if(task_reportDao.addLite(param))
        {
            //update task
            Task task = task_reportDao.upDateTaskLite(param);
            if(task !=null)
            {
                Modul modul = modulDao.upDateModul(task);
                if(modul !=null)
                {
                    projectDao.UpdateTaskProject(modul);
                }
            }
        }

        return param;
    }

    //clear data sabolum upload
    public boolean clearDataDb(int id_projec)
    {
        List<Modul> moduls = modulDao.getList(id_projec);
        for(Modul modul:moduls)
        {
            List<Task> tasks = taskDao.getAllModul(modul.getId_modul());
            for(Task task:tasks)
            {
                taskDao.deleted(task);
            }
            modulDao.deleted(modul);
        }
        return true;
    }


    public boolean importData(int id_project, String path) throws IOException, ParseException {
        //cek apokah status project open
        Project projectCheck = projectDao.detailLite(id_project);
        if(projectCheck.getIs_lock() > 0)
        {
            return false;
        }

        this.clearDataDb(id_project);
        String excelFilePath = path;

        ExcelHelp help = new ExcelHelp();

        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        //persiapan-------------------
        Date task_awal;
        int row = firstSheet.getLastRowNum();
        int mulai_itung = 0;
        //-----------------/

        int n=0;
        int cek_sasudah_modul = 0;
        int id_modul =0;
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                if(columnIndex==0)
                {
                    //cari tanggal mulai
                    String val = (String) help.getCellValue(nextCell);
                    if(val.matches("@"))
                    {
                        mulai_itung = nextRow.getRowNum();
                        task_awal = nextRow.getCell(2).getDateCellValue();
                        System.out.println(nextRow.getRowNum() + "iko nyo tanggal------------>");

                    }
                }
            }


            if(mulai_itung > 0 && nextRow.getCell(0) != null)
            {
                //masuan Modul
                if(help.RomawiKaInt(nextRow.getCell(0).toString()) < 100)
                {
                    cek_sasudah_modul = 1;
                    Modul modul = new Modul();
                    modul.setId_project(id_project);
                    modul.setUrutan(help.RomawiKaInt(nextRow.getCell(0).toString()));
                    modul.setModul(nextRow.getCell(1).toString());
                    modulDao.add(modul);
                    id_modul = modul.getId_modul();

                    System.out.println(modul.getModul() + "");
                }
            }
            else if(cek_sasudah_modul > 0 && cek_sasudah_modul < nextRow.getRowNum())
            {
                //masuan ka task;
                if(nextRow.getCell(1) != null)
                {
                    Task task = new Task();
                    task.setId_modul(id_modul);
                    task.setTask(nextRow.getCell(1).toString());
                    double bobot = help.round(nextRow.getCell(2).getNumericCellValue(),6);
                    task.setBobot(String.valueOf(bobot));
                    task.setTask_progress((long) nextRow.getCell(2).getNumericCellValue());
                    task.setTask_nilai((long) nextRow.getCell(3).getNumericCellValue());
                    task.setSatuan(nextRow.getCell(4).toString());
                    task.setTask_fee((long) nextRow.getCell(5).getNumericCellValue());

                    int minggu = (int) nextRow.getCell(7).getNumericCellValue();
                    Date tgl_mulai = nextRow.getCell(8).getDateCellValue();


                    Date tgl_end = help.addDays(tgl_mulai,(7 * minggu)-1);
                    task.setTask_start(tgl_mulai);
                    task.setTask_end(tgl_end);

                    taskDao.create(task);
                    System.out.println(minggu + "--->" + task.getTask() + "");
                }

            }

            n++;

        }

        workbook.close();
        inputStream.close();
        return true;
    }



}
