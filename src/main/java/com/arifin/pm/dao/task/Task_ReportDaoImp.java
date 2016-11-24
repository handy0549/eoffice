package com.arifin.pm.dao.task;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Task_Report;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
                "WHERE  a.ID_TASK_REPORT >= b.ID_TASK_REPORT) TOTAL_PROGRESS\n" +
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
    public boolean add(Task_Report report) {
        persist(report);
        return true;
    }

    @Override
    public boolean edit(Task_Report report) {
        update(report);
        return true;
    }
}
