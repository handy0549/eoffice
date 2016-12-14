package com.arifin.Acl.Dao;

import com.arifin.Acl.Model.User_group;
import com.arifin.abstrac.AbstractDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 12/2/2016.
 */
@Transactional
@Component
public class User_groupDao extends AbstractDao<Integer,User_group>{

    public List<User_group> getAll()
    {
        List<User_group> user_groups = getSession().createCriteria(User_group.class).list();
        return user_groups;
    }

    public User_group getDetail(int id_group)
    {
        User_group user_group = (User_group) getSession().get(User_group.class,id_group);
        return user_group;
    }

    public boolean add(User_group user_group)
    {
        persist(user_group);
        return true;
    }

    public boolean edit(User_group user_group)
    {
        update(user_group);
        return true;
    }
}
