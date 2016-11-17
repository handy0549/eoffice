package com.arifin.pm.dao.perusahaan;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Perusahaan_Izin;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 09/11/2016.
 */
@Repository("Perusahaan_izinDaoImp")
@Transactional
public class Perusahaan_izinDaoImp extends AbstractDao<Integer, Perusahaan_Izin> implements Perusaahaan_IzinDao {

    @Override
    public List<Object[]> getAll() {
        return null;
    }

    @Override
    public List<Perusahaan_Izin> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Perusahaan_Izin>) criteria.list();
    }
}
