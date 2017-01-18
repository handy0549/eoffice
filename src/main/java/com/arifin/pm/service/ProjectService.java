package com.arifin.pm.service;

import com.arifin.pm.dao.project.ModulDao;
import com.arifin.pm.dao.task.TaskDao;
import com.arifin.pm.dao.task.TaskTimeline;
import com.arifin.pm.model.Modul;
import com.arifin.pm.model.Task;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    ModulDao modulDao;

    public Object getTimeline(int id_project)
    {
        List<Map<String, String>> intervalMinggus = taskTimeline.getIntervalMinggu(id_project);

        Map<String,Object> timelie = new HashMap<>();


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
                taskParam.put("start",task.getTask_end());
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
}
