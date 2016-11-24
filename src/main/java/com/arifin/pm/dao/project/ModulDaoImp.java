package com.arifin.pm.dao.project;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Modul;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
    public List<Modul> getList(int id_project) {
        Criteria criteria = getSession().createCriteria(Modul.class);
        criteria.add(Restrictions.eq("id_project",id_project));
        criteria.add(Restrictions.disjunction()
                .add(Restrictions.isNull("is_deleted"))
                .add(Restrictions.eq("is_deleted",0))
        );
        return (List<Modul>) criteria.list();
    }

    @Override
    public Modul getDetailLite(int id_modul) {
        Modul modul = (Modul) getSession().get(Modul.class,id_modul);
        return modul;
    }

    @Override
    public Boolean add(Modul modul) {
        persist(modul);
        return true;
    }

    @Override
    public Boolean edit(Modul modul) {
        update(modul);
        return true;
    }
}
