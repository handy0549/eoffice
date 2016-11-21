package com.arifin.pm.dao.perusahaan;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Perusahaan_Pegawai;
import com.arifin.pm.model.Perusahaan_jabatan;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 09/11/2016.
 */
@Repository("Perusahaan_PegawaiDaoImp")
@Transactional
public class Perusahaan_PegawaiDaoImp extends AbstractDao<Integer, Perusahaan_Pegawai> implements Perusahaan_PegawaiDao {


    @Override
    public List getAll(int id) {
        Criteria criteria = createEntityCriteria();
                criteria.add(Restrictions.eq("id_perusahaan",id));
                criteria.addOrder(Order.asc("nama_pegawai_p"));

        String Sql = "Select {a.*},{b.*} " +
                "from PM_PERUSAHAAN_PEGAWAI a, " +
                "t_perusahaan_jabatan b " +
                "where a.id_jabatan_p=b.id_jabatan_p " +
                "and a.id_perusahaan= " + id + " " +
                "order by a.nama_pegawai_p ASC ";
        SQLQuery query = getSession().createSQLQuery(Sql);
        query.addEntity("a",Perusahaan_Pegawai.class);
        query.addEntity("b", Perusahaan_jabatan.class);
        List datas = query.list();
        return datas;
    }

    @Override
    public Perusahaan_Pegawai getDetailPegawai(int id)
    {
        Criteria criteria =   getSession().createCriteria(Perusahaan_Pegawai.class);
        criteria.add(Restrictions.eq("id_perusahaan_pegawai",id));
        Perusahaan_Pegawai pegawai = (Perusahaan_Pegawai) criteria.uniqueResult();
        return pegawai;
    }

    @Override
    public boolean addPegawai(Perusahaan_Pegawai perusahaan_pegawai) {
        try
        {
            getSession().persist(perusahaan_pegawai);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean editPegawai(Perusahaan_Pegawai pegawai)
    {
        update(pegawai);
        return true;
    }
}
