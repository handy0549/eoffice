package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Project_jenis;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 10/11/2016.
 */
@Repository
@Transactional
public class Project_jenisDaoImp extends AbstractDao<Integer, Project_jenis> implements Project_jenisDao {

    @Override
    public List<Object[]> getAll() {
        return null;
    }

    @Override
    public List<Project_jenis> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Project_jenis>) criteria.list();
    }
}
