package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Dokumen;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 08/11/2016.
 */
@Repository
@Transactional
public class DokumenDaoImp extends AbstractDao<Integer, Dokumen> implements DokumenDao {

    @Override
    public List<Object[]> getAll() {
        return null;
    }

    @Override
    public List<Dokumen> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Dokumen>) criteria.list();
    }
}
