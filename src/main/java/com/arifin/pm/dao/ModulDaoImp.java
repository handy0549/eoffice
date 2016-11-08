package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Modul;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 08/11/2016.
 */


@Repository
@Transactional
public class ModulDaoImp extends AbstractDao<Integer, Modul> implements ModulDao {
    @Override
    public List<Object[]> getAll() { return null; }


    @Override
    public List<Modul> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Modul>) criteria.list();
    }
}
