package com.arifin.Acl.Dao;

import com.arifin.Acl.Model.User_group_detail;
import com.arifin.Acl.Model.User_group_detail;
import com.arifin.abstrac.AbstractDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 12/2/2016.
 */
@Transactional
@Component
public class User_group_detailDao extends AbstractDao<Integer,User_group_detail> {
    public List<User_group_detail> getAll()
    {
        List<User_group_detail> user_group_details = getSession().createCriteria(User_group_detail.class).list();
        return user_group_details;
    }

    public User_group_detail getDetail(int id_group)
    {
        User_group_detail user_group_detail = (User_group_detail) getSession().get(User_group_detail.class,id_group);
        return user_group_detail;
    }

    public boolean add(User_group_detail user_group_detail)
    {
        persist(user_group_detail);
        return true;
    }

    public boolean edit(User_group_detail user_group_detail)
    {
        update(user_group_detail);
        return true;
    }

}
