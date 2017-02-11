package com.arifin.Acl.Dao;

import com.arifin.Acl.Model.User_akses;
import com.arifin.abstrac.AbstractDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 12/2/2016.
 */
//@Component
@Transactional
@Repository
public class User_aksesDao extends AbstractDao<Integer,User_akses> {
    public List<User_akses> getAll(int id_modul)
    {
        List<User_akses> user_akses = getSession().createCriteria(User_akses.class)
                .add(Restrictions.eq("id_modul",id_modul))
                .list();
        return user_akses;
    }

    public User_akses getDetail(int id_akses)
    {
        User_akses user_akses = (User_akses) getSession().get(User_akses.class,id_akses);
        return user_akses;
    }

    public boolean add(User_akses user_akses)
    {
        persist(user_akses);
        return true;
    }
    public boolean edit(User_akses user_akses)
    {
        update(user_akses);
        return true;
    }
}