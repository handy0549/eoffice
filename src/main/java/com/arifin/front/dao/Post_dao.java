package com.arifin.front.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.front.model.Post;
import com.arifin.helper.ToSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by ojiepermana on 3/20/2017.
 */
@Transactional
@Component
public class Post_dao extends AbstractDao<String,Post> {
    @Autowired
    ToSql toSql;

    public Post getById(String id_post)
    {
        return (Post) getSession().get(Post.class,id_post);
    }
    public List getAll(Map<String,String > param, Boolean page)
    {
        String Sql = "Select   ";

        Sql=toSql.Where(Sql, param,"a", page);
        Sql+=" ORDER  BY a.id_project DESC ";
    }
}
