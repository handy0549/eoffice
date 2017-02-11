package com.arifin.pm.dao.task;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Task_report_media;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 11/25/2016.
 */
@Transactional
@Component
public class Task_report_media_dao extends AbstractDao<Integer,Task_report_media>{

    public List<Task_report_media> getAllReport(int id_task_report)
    {
        List<Task_report_media> media =  getSession().createCriteria(Task_report_media.class)
                .add(Restrictions.eq("id_task_report",id_task_report))
                .list();
        return media;
    }


    //PR--
    public List getAlltask(int id_task)
    {
        String Sql="SELECT  a.*,\n" +
                "    c.NAMA_PEGAWAI_P,\n" +
                "    b.REPORT_TANGGAL\n" +
                "\n" +
                "  FROM PM_TASK_REPORT_MEDIA a,\n" +
                "    PM_TASK_REPORT b ,\n" +
                "    PM_PERUSAHAAN_PEGAWAI c\n" +
                "\n" +
                "where a.ID_TASK_REPORT=b.ID_TASK_REPORT\n" +
                "and b.ID_PERUSAHAAN_PEGAWAI=c.ID_PERUSAHAAN_PEGAWAI\n" +
                "and b.ID_TASK=" + id_task;

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List data = query.list();

        return data;
    }

    public Task_report_media getDetail(int id_media)
    {
        return getByKey(id_media);
    }

    public boolean add(Task_report_media media)
    {
        media.setFilenyo("");
        getSession().persist(media);
        return true;
    }

}
