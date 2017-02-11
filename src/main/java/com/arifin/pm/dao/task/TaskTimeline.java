package com.arifin.pm.dao.task;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Project;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by ojiepermana on 1/18/2017.
 */
@Transactional
@Component
public class TaskTimeline extends AbstractDao<Integer,Project> {

    public Map<String,String> getData(int id_task)
    {

//        String Sql="SELECT * from (\n" +
//                "  SELECT\n" +
//                "    max(b.URUTAN) as urutan," +
//                "  max(b.MODUL) as modul,\n" +
//                "  max(b.ID_MODUL) as id_modul,\n" +
//                "  max(a.TASK) as task,\n" +
//                "  max(a.ID_TASK) as id_task,\n" +
//                "  max(a.BOBOT) as bobot,\n" +
//                "  max(a.TASK_PROGRESS) as TASK_PROGRESS,\n";
//
////        List<Object> intervalMinggus = this.getIntervalMinggu(id_project);
////        for (Object item:intervalMinggus)
////        {
////            Map<String,String> param = (Map<String, String>) item;
////            System.out.println(param.get("MULAI")+"-->XX");
////
////            int awal_tahun =Integer.parseInt(param.get("MULAI_TAHUN").toString());
////            int akhir_tahun = Integer.parseInt(param.get("SELESAI_TAHUN").toString());
////
////            int awal =Integer.parseInt(param.get("MULAI").toString());
////            int akhir = Integer.parseInt(param.get("SELESAI").toString());
////            int selisih = 53 - awal;
////            int interval = akhir-selisih;
////
////            for(int i=0; i < interval; i++ )
////            {
////
////                Sql+=   "    (CASE\n" +
////                        "      WHEN max(to_char(a.TASK_START - 7/24,'WW')) >= "+ awal +" and max(to_char(a.TASK_END - 7/24,'WW')) <= "+ awal +"\n" +
////                        "        THEN 1 ELSE 0\n" +
////                        "     END) AS value"+ i +",\n" +
////                        "\n";
////                if(awal==53)
////                {
////                    awal=0;
////                }
////                awal++;
////            }
////
////            System.out.println(param + "-------------->");
////        }
//
//        Sql+=   "  max(to_char(a.TASK_START - 7/24,'IYYY')*1) as tahun,\n" +
//                "  max(to_char(a.TASK_START - 7/24,'WW')*1) as minggu_awal, \n" +
//                "  max(to_char(a.TASK_END - 7/24,'WW')*1) as minggu_akhir,\n" +
//                "  max(to_char(a.TASK_START - 7/24,'MONTH')) as bulan, \n" +
//                "  max(a.TASK_START) as tgl\n" +
//                "\n" +
//                "FROM PM_TASK a,\n" +
//                "  PM_MODUL b\n" +
//                "\n" +
//                "  WHERE a.ID_MODUL=b.ID_MODUL\n" +
//                "  and b.ID_PROJECT=9050\n" +
//                "GROUP BY a.id_task ";
//        Sql+=" ) ORDER BY urutan,tgl ";

        String Sql="   SELECT\n" +
                "      a.BOBOT,\n" +
                "     to_char(a.TASK_START - 7 / 24, 'IYYY')        AS tahun_awal,\n" +
                "     to_char(a.TASK_end - 7 / 24, 'IYYY')        AS tahun_akhir,\n" +
                "     to_char(a.TASK_START - 7 / 24, 'WW')      AS minggu_awal,\n" +
                "     to_char(a.TASK_END - 7 / 24, 'WW')       AS minggu_akhir,\n" +
                "     to_char(a.TASK_START - 7 / 24, 'MONTH')  AS bulan,\n" +
                "      to_char(a.TASK_START,'yyyy-mm-dd') AS mulai,\n" +
                "      to_char(a.TASK_END,'yyyy-mm-dd') AS target\n" +
                "  FROM PM_TASK a\n" +
                "\n" +
                "  WHERE  a.ID_TASK = "+id_task;

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        Map<String,String> rows = (Map<String, String>) query.uniqueResult();

        return rows;
    }

    public List getIntervalMinggu(int id_project)
    {
        String Sql=" SELECT\n" +
                "to_char(a.TANGGAL_MULAI - 7/24,'WW') as mulai, -- bulan\n" +
                "to_char(a.TANGGAL_MULAI,'yyyy-mm-dd') as tgl_mulai,\n" +
                "to_char(a.TANGGAL_MULAI,'dd') as tgl_mulai_hari,\n" +
                "to_char(a.BATAS_WAKTU,'yyyy-mm-dd') as tgl_akhir,\n" +
                "to_char(a.BATAS_WAKTU,'dd') as tgl_akhir_hari,\n" +
                "to_char(a.TANGGAL_MULAI - 7/24,'YYYY') as mulai_tahun, -- bulan\n" +
                "to_char(a.BATAS_WAKTU - 7/24,'WW') as selesai, -- bulan\n" +
                "to_char(a.BATAS_WAKTU - 7/24,'YYYY') as selesai_tahun -- bulan\n" +
                "\n" +
                "from PM_PROJECT a\n" +
                "WHERE a.ID_PROJECT=9050\n";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();

        return rows;
    }

    //##
    public List getTimelineProgress(int id_modul)
    {
        String Sql="SELECT * from (\n" +
                "  SELECT\n" +
                "    to_char(a.REPORT_TANGGAL - 7 / 24, 'IW') as minggu,\n" +
                "    sum(a.REPORT_PROGRESS) AS progress,\n" +
                "    max(to_char(a.REPORT_TANGGAL, 'YYYY-MM-DD')) as tanggal\n" +
                "  FROM\n" +
                "    PM_TASK_REPORT a,\n" +
                "    PM_TASK b,\n" +
                "    PM_MODUL c\n" +
                "\n" +
                "  WHERE a.ID_TASK = b.ID_TASK\n" +
                "        AND b.ID_MODUL = c.ID_MODUL\n" +
                "        AND b.id_modul= "+ id_modul +" \n" +
                "\n" +
                "  GROUP BY to_char(a.REPORT_TANGGAL - 7 / 24, 'IW'), to_char(a.REPORT_TANGGAL - 7 / 24, 'YYYY')\n" +
                ") ORDER BY minggu";

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();

        return rows;
    }



}
