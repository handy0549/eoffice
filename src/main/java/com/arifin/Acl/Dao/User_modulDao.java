package com.arifin.Acl.Dao;

import com.arifin.Acl.Model.User_modul;
import com.arifin.abstrac.AbstractDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 12/2/2016.
 */
@Transactional
@Component
public class User_modulDao extends AbstractDao<Integer,User_modul> {

    public List<User_modul> getAll()
    {
        List<User_modul> user_modul = getSession().createCriteria(User_modul.class).list();
        return user_modul;
    }

    public User_modul getDetail(int id_akses)
    {
        User_modul user_modul = (User_modul) getSession().get(User_modul.class,id_akses);
        return user_modul;
    }

    public boolean add(User_modul user_modul)
    {
        persist(user_modul);
        return true;
    }
    public boolean edit(User_modul user_modul)
    {
        update(user_modul);
        return true;
    }
}
