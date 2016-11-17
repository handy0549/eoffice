package com.arifin.pm.dao.project;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Project_paket;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Handy on 10/11/2016.
 */
@Repository("Project_paketDaoImp")
@Transactional
public class Project_paketDaoImp extends AbstractDao<Integer, Project_paket> implements Project_paketDao {

    @Override
    public List<Object[]> getAll() {
        return null;
    }

    @Override
    public List<Project_paket> getList() {
        Criteria criteria = createEntityCriteria();
        return (List<Project_paket>) criteria.list();
    }

}
