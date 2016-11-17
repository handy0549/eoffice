package com.arifin.security.service;

import com.arifin.abstrac.AbstractDao;
import com.arifin.security.model.AppUser;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "appUserService")
public class AppUserServiceImpl extends AbstractDao<Integer,AppUser > implements AppUserService {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public AppUser loadUserByUsername(String username) {
        System.out.println("out "+ username);
        AppUser appUser = (AppUser) getSession()
                        .createCriteria(AppUser.class)
                        .add(Restrictions.eq("username", username))
                        .uniqueResult();

        return appUser;
    }

    @Transactional
    @Override
    public long post(AppUser appUser) {
        return (long) sessionFactory.getCurrentSession().save(appUser);
    }

    @Transactional
    @Override
    public AppUser get(long id) {
        return (AppUser) getSession().get(AppUser.class, id);
    }

    @Transactional
    @Override
    public AppUser patch(AppUser appUser) {
        getSession().update(appUser);
        return get(appUser.getId());
    }

    @Transactional
    @Override
    public boolean delete(long id) {
        getSession().delete(get(id));
        return true;
    }
}
