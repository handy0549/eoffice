package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Perusahaan_Pegawai;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 09/11/2016.
 */
@Repository
@Transactional
public class Perusahaan_PegawaiDaoImp extends AbstractDao<Integer, Perusahaan_Pegawai> implements Perusahaan_PegawaiDao {

    @Override
    public List<Object[]> getAll() {
        return null;
    }

    @Override
    public List<Perusahaan_Pegawai> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Perusahaan_Pegawai>) criteria.list();
    }
}
