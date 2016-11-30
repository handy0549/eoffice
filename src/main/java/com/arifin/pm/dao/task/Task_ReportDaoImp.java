package com.arifin.pm.dao.task;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Task;
import com.arifin.pm.model.Task_Report;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 10/11/2016.
 */
@Repository("Task_ReportDaoImp")
@Transactional
public class Task_ReportDaoImp extends AbstractDao<Integer, Task_Report> implements Task_ReportDao{


    @Override
    public List<Object[]> getAll(int id_task) {
        String Sql = "SELECT a.*,\n" +
                "  c.NAMA_PEGAWAI_P ,\n" +
                "(SELECT Sum(b.REPORT_PROGRESS)\n" +
                "FROM   PM_TASK_REPORT b\n" +
                "WHERE  a.ID_TASK_REPORT >= b.ID_TASK_REPORT " +
                " and b.ID_TASK= " + id_task +" " +
                ") TOTAL_PROGRESS\n" +
                "FROM PM_TASK_REPORT a,\n" +
                "PM_PERUSAHAAN_PEGAWAI c \n" +
                "WHERE  a.ID_PERUSAHAAN_PEGAWAI=c.ID_PERUSAHAAN_PEGAWAI " +
                "and a.ID_TASK= " + id_task + " " +
                "ORDER BY a.ID_TASK_REPORT ASC ";


        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        return  query.list();
    }

    @Override
    public Object getTaskReport(int id_task) {
        String Sql = "SELECT\n" +
                "  max(a.ID_TASK) as ID_TASK,\n" +
                "  count(a.ID_TASK_REPORT) as juml_report,\n" +
                "  sum(a.REPORT_PROGRESS) as  REPORT_PROGRESS\n" +
                "\n" +
                "FROM PM_TASK b\n" +
                "  LEFT JOIN PM_TASK_REPORT a on (a.ID_TASK=b.ID_TASK and b.IS_DELETED=0)\n" +
                "\n" +
                "WHERE   b.ID_TASK=" + id_task +"\n" +
                "GROUP BY b.ID_TASK";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        return  query.uniqueResult();
    }

    @Override
    public Object getDetail(int id_task_report) {
        String Sql = "SELECT\n" +
                "  a.*,\n" +
                "  b.NAMA_PEGAWAI_P,\n" +
                "  b.NIP\n" +
                "  FROM PM_TASK_REPORT a,\n" +
                "    PM_PERUSAHAAN_PEGAWAI b\n" +
                "\n" +
                "WHERE a.ID_PERUSAHAAN_PEGAWAI=b.ID_PERUSAHAAN_PEGAWAI\n" +
                "  \n" +
                "and a.ID_TASK_REPORT="+ id_task_report +"\n";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        return  query.uniqueResult();
    }


    @Override
    public Task_Report getDetailLite(int id_task_report) {
        Task_Report report = (Task_Report) getSession().get(Task_Report.class,id_task_report);
        return report;
    }

    @Override
    public boolean add(Map<String,String> report) {
        if(report.get("report_tanggal") !=null)
        {
            String report_tanggal = report.get("report_tanggal");
            String[] report_tanggal_s = report_tanggal.split("T");

            String tgl_acc= "0000-00-00T";
            if(report.get("tgl_acc") !=null)
            {
                tgl_acc = report.get("tgl_acc");
            }
            String[] tgl_acc_s = tgl_acc.split("T");



            String Sql = "INSERT INTO  PM_TASK_REPORT  " +
                    "(id_perusahaan_pegawai, id_task, report_detail,report_progress ,report_status,report_tanggal,tgl_acc) " +
                    "VALUES (" +
                    " " + report.get("id_perusahaan_pegawai")+ ", " +
                    " " + report.get("id_task")+ ", " +
                    " '" + report.get("report_detail")+ "', " +
                    " " + report.get("report_progress")+ ", " +
                    " '" + report.get("report_status")+ "', " +
                    " TO_DATE('" + report_tanggal_s[0] + "', 'yyyy-mm-dd') , " +
                    " TO_DATE('" + tgl_acc_s[0] + "', 'yyyy-mm-dd')   " +
                    " )\n";
            SQLQuery query = getSession().createSQLQuery(Sql);
            query.executeUpdate();

            return true;

        }

        return false;
    }

    @Override
    public boolean edit(Map report) {
//        update(report);
        return true;
    }
    @Override
    public Task upDateTask(Map<String,String> param) {
        Task task = getMaxTask(Integer.parseInt(param.get("id_task")) );

        if(task.getTask_progress_realisasi() <= 100)
        {
            System.out.println("dibawah 100");
            String Sql =" Update PM_TASK set TASK_PROGRESS_REALISASI = TASK_PROGRESS_REALISASI + "+ param.get("report_progress") +"\n" +
                    "WHERE ID_TASK=" + param.get("id_task");
            SQLQuery query = getSession().createSQLQuery(Sql);
            query.executeUpdate();
            return task;
        }
        else
        {
            return null;
        }


    }

    private Task getMaxTask(int id_task)
    {
        Task task = (Task) getSession().get(Task.class,id_task);
        System.out.println("task realisai" + task.getTask_progress_realisasi());
        return task;
    }
}
