package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Project;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 12/7/2016.
 */
@Transactional
@Component
public class GrafikDao extends AbstractDao<Integer,Project>{

    //sub_laporan per task
    public List getLaporanPerTask(int id_project)
    {
        String Sql = "select * from (SELECT\n" +
                "max(a.ID_TASK) as id_task,\n" +
                "sum(a.BOBOT) as rencana,\n" +
                "sum(a.TASK_PROGRESS_REALISASI/100*a.BOBOT) as relisasi ,\n" +
                "max(to_char(a.TASK_END,'yyyy-mm-dd') ) as tgl_rencana,\n" +
                "max(to_char(c.TANGGAL_MULAI,'yyyy-mm-dd') ) as TANGGAL_MULAI,\n" +
                "max(to_char(a.TASK_END,'yyyymmdd')) as int_rencana\n" +
                "\n" +
                "FROM PM_TASK a,\n" +
                " PM_MODUL b,\n" +
                " PM_PROJECT c\n" +
                "WHERE a.ID_MODUL=b.ID_MODUL " +
                "and b.id_project=c.id_project " +
                "and b.ID_PROJECT ="+ id_project +"\n" +
                "and a.IS_DELETED < 1\n" +
                "and b.IS_DELETED < 1\n" +
                "\n" +
                "GROUP BY a.TASK_END) ORDER by int_rencana ASC";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();

        return rows;
    }

    //#untuk projek
    public List getKurvaProjectProgres(int id_project)
    {
        String Sql="SELECT * from (\n" +
                "  SELECT\n" +
                "    to_char(a.REPORT_TANGGAL - 7 / 24, 'IW') as minggu,\n" +
                "    sum((a.REPORT_PROGRESS/100)*b.BOBOT) AS progress, \n" +
                "    max(a.REPORT_TANGGAL) as REPORT_TANGGAL,\n" +
                "    max(to_char(a.REPORT_TANGGAL, 'YYYY-MM-DD')) as tanggal\n" +
                "  FROM\n" +
                "    PM_TASK_REPORT a,\n" +
                "    PM_TASK b,\n" +
                "    PM_MODUL c,\n" +
                "    PM_PROJECT d\n" +
                "\n" +
                "  WHERE a.ID_TASK = b.ID_TASK\n" +
                "        AND b.ID_MODUL = c.ID_MODUL\n" +
                "    and  c.ID_PROJECT=d.ID_PROJECT\n" +
                "     and d.ID_PROJECT=" + id_project +"\n" +
                "\n" +
                "\n" +
                "  GROUP BY to_char(a.REPORT_TANGGAL - 7 / 24, 'IW'), to_char(a.REPORT_TANGGAL - 7 / 24, 'YYYY')\n" +
                ") ORDER BY REPORT_TANGGAL";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();

        return rows;
    }

    public List getKurvaProjectTask(int id_project)
    {
        String Sql=" SELECT * from (\n" +
                "  SELECT\n" +
                "    to_char(b.TASK_START - 7 / 24, 'IW') as minggu,\n" +
                "    sum(b.BOBOT) AS bobot,\n" +
                "    max(b.TASK_START) as task_start,\n" +
                "    max(b.TASK_END) as task_end\n" +
                "  FROM\n" +
                "    PM_TASK b,\n" +
                "    PM_MODUL c\n" +
                "\n" +
                "  WHERE   b.ID_MODUL = c.ID_MODUL\n" +
                "    and c.ID_PROJECT="+ id_project +"\n" +
                "\n" +
                "\n" +
                "  GROUP BY to_char(b.TASK_START - 7 / 24, 'IW'), to_char(b.TASK_START - 7 / 24, 'YYYY')\n" +
                ") ORDER BY task_start";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();

        return rows;
    }

    
}
