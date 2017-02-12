package com.arifin.pm.service;

import com.arifin.helper.QueryHelp;
import com.arifin.pm.dao.GrafikDao;
import com.arifin.pm.dao.project.AddendumDao;
import com.arifin.pm.dao.project.ModulDao;
import com.arifin.pm.dao.project.ProjectDao;
import com.arifin.pm.dao.task.TaskDao;
import com.arifin.pm.dao.task.TaskTimeline;
import com.arifin.pm.dao.task.Task_ReportDao;
import com.arifin.pm.dao.task.Task_report_media_dao;
import com.arifin.pm.model.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by ojiepermana on 1/18/2017.
 */
@Transactional
@Service
@Component
public class ProjectService {

    @Autowired
    TaskTimeline taskTimeline;

    @Autowired
    TaskDao taskDao;

    @Autowired
    Task_ReportDao task_reportDao;

    @Autowired
    Task_report_media_dao task_report_media_dao;

    @Autowired
    ProjectDao projectDao;

    @Autowired
    AddendumDao addendumDao;

    @Autowired
    ModulDao modulDao;

    @Autowired
    GrafikDao grafikDao;

    @Autowired
    QueryHelp help;

    //Lama, ga dipake
    public Object getTimeline(int id_project)
    {
        List<Map<String, String>> intervalMinggus = taskTimeline.getIntervalMinggu(id_project);

        Map<String,Object> timelie = new HashMap<>();

        //loop tanggal peride
        Project project = projectDao.detailLite(id_project);

        Date startDate = project.getTanggal_mulai();
        Date endDate = project.getBatas_waktu();

        SimpleDateFormat sm = new SimpleDateFormat("MM");
        String strDate = sm.format(startDate);


        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startDate);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

        timelie.put("bulan_mulai",strDate);
        timelie.put("bulan_interval",diffMonth);


        /*------------ --> */


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int jml_mingu = 0;
        List<Object> datas = new ArrayList<Object>();
        List<Modul> moduls = modulDao.getList(id_project);
        for (Modul modul:moduls)
        {
            Map<String,Object> modulParam = new HashMap<>();
            modulParam.put("modul",modul.getModul());
            modulParam.put("id_modul",modul.getId_modul());

            //task
            List<Object> datasTask = new ArrayList<Object>();
            List<Task> tasks = taskDao.getAllModul(modul.getId_modul());
            for (Task task:tasks)
            {
                Map<String,Object> taskParam = new HashMap<>();
                taskParam.put("task",task.getTask());
                taskParam.put("id_task",task.getId_task());
                taskParam.put("progress",task.getTask_progress());
                taskParam.put("bobot",task.getBobot());
                taskParam.put("nilai",task.getTask_nilai());
                taskParam.put("fee",task.getTask_fee());
                taskParam.put("start",task.getTask_start());
                taskParam.put("end",task.getTask_end());
                taskParam.put("satuan",task.getSatuan());
                taskParam.put("realisai",task.getTask_progress_realisasi());
                taskParam.put("ren_val",1);


                //progress
                List<Object> datasTaskProgress = new ArrayList<Object>();
                Map<String,String> task_progres = taskTimeline.getData(task.getId_task());
                System.out.println(task_progres.get("MINGGU_AWAL") + " ccccccccccccccccccccc==================");

                    int rencana_awal =Integer.parseInt("" + task_progres.get("MINGGU_AWAL").toString());
                    int rencana_akhir = Integer.parseInt("" + task_progres.get("MINGGU_AKHIR").toString());

                    taskParam.put("rencana_awal",rencana_awal);
                    taskParam.put("rencana_akhir",rencana_akhir);

                    for (Map<String, String> param:intervalMinggus)
                    { //ambil indek pertama dari interval mingguan
                        System.out.println(param.get("MULAI")+"-->XX");

                        int awal =Integer.parseInt(param.get("MULAI").toString());
                        int akhir = Integer.parseInt(param.get("SELESAI").toString());
                        int selisih = 53 - awal;
                        int interval = akhir-selisih;
                        jml_mingu=interval;
                        int indek = 0;

                        //looping total minggu periode
                        for(int i=0; i < interval; i++ )
                        {
                            Map<String,Object> taskParam_bobot = new HashMap<>();
                            if(rencana_awal==awal || rencana_awal < awal && rencana_akhir > awal )
                            {
                                indek++;
                                taskParam.put("ren_val",indek);
                                taskParam_bobot.put("rencana",1);
                            }
                            else
                            {
                                taskParam_bobot.put("rencana",0);
                            }

                            datasTaskProgress.add(taskParam_bobot);

                            if(awal==53)
                            {
                                awal=0;
                            }
                            awal++;
                        }

                        System.out.println(param + "-------------->");
                    }
                    taskParam.put("loop_rencana",datasTaskProgress);

                datasTask.add(taskParam);
                System.out.println(taskParam);

                //batas
            }
            modulParam.put("task",datasTask);

            datas.add(modulParam);
        }
        timelie.put("datas",datas);
        timelie.put("minggu",jml_mingu);
        return timelie;
    }

    public Object getTimelineHarian(int id_project)
    {
        Project project = projectDao.detailLite(id_project);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> timelie = new HashMap<>();
        timelie.put("project",project);

        List<Object> datas = new ArrayList<Object>();
        List<Modul> moduls = modulDao.getList(id_project);
        for (Modul modul:moduls)
        {
            Map<String,Object> modulParam = new HashMap<>();
            List<Task> task = taskDao.getAllModul(modul.getId_modul());
            List report = taskTimeline.getTimelineProgress(modul.getId_modul());

            modulParam.put("modul",modul);
            modulParam.put("task",task);
            modulParam.put("report",report);
            datas.add(modulParam);

        }
        timelie.put("datas",datas);
        return timelie;
    }

    public Object getKurvas(int id_project)
    {
        Project project = projectDao.detailLite(id_project);

        Map<String,Object> kurva = new HashMap<>();
        kurva.put("project",project);

        List task = grafikDao.getKurvaProjectTask(id_project);
        kurva.put("task",task);
        List progress = grafikDao.getKurvaProjectProgres(id_project);
        kurva.put("progress",progress);

        kurva.put("datas","asdsa");
        return kurva;
    }

    //ADENDUM

    public boolean createdAddendum(Addendum addendum)
    {
        int id_project = addendum.getId_project();
        //copy project
        Project project = projectDao.detailLite(id_project);
        Project clone = (Project) project.clone();
        clone.setIs_addendum(1);
        clone.setIs_lock(1);
        projectDao.create(clone);

        //set status Project lock open
        project.setIs_lock(0);
        projectDao.update(id_project,project);

        //copy Modul
        List<Modul> moduls= modulDao.getList(id_project);
        for (Modul modul:moduls)
        {
            //System.out.println("1------------" + clone.getId_project());
            Modul cloneModul = (Modul) modul.clone();
            cloneModul.setId_project(clone.getId_project());
            modulDao.add(cloneModul);

            //copy task
            List<Task> tasks = taskDao.getAllModul(modul.getId_modul());
            for (Task task:tasks)
            {
                Task cloneTask = (Task) task.clone();
                cloneTask.setId_modul(cloneModul.getId_modul());
                taskDao.create(cloneTask);

                List<Task_Report> reports = task_reportDao.getAllLite(task.getId_task());
                for (Task_Report report:reports)
                {
                    Task_Report cloneReport = (Task_Report) report.clone();
                    cloneReport.setId_task(cloneTask.getId_task());
                    task_reportDao.addLite(cloneReport);

                    List<Task_report_media> medias = task_report_media_dao.getAllReport(report.getId_task_report());
                    for (Task_report_media media:medias)
                    {
                        Task_report_media cloneMedia = (Task_report_media) media.clone();
                        cloneMedia.setId_task_report(cloneReport.getId_task_report());
                        task_report_media_dao.add(cloneMedia);
                    }
                }

            }
        }
        addendum.setId_project(id_project);
        addendum.setId_child_project(clone.getId_project());
        addendum.setId_user(help.getIdUser());

        addendumDao.Add(addendum);

        return true;
    }


}

