package com.arifin.Acl.Dao;

import com.arifin.Acl.Model.User;
import com.arifin.abstrac.AbstractDao;
import com.arifin.helper.ToSql;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by ojiepermana on 12/2/2016.
 */
@Transactional
@Component("UserDao")
public class UserDao extends AbstractDao<Integer,User> {
    @Autowired
    ToSql toSql;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List getAll(Map<String,String> param, boolean page)
    {
        String Sql = "SELECT\n" +
                "  a.EMAIL,\n" +
                "  a.ID_PEGAWAI,\n" +
                "  a.JENIS,\n" +
                "  a.ID , \n" +
                "  a.STATUS,\n" +
                "  b.*,\n" +
                "  d.*,\n" +
                "  c.NAMA_PERUSAHAAN\n" +
                "From USERS a\n" +
                "LEFT JOIN PM_PERUSAHAAN_PEGAWAI b on (a.ID_PEGAWAI=b.ID_PERUSAHAAN_PEGAWAI and a.JENIS='p')\n" +
                "LEFT JOIN PM_PERUSAHAAN c on (b.ID_PERUSAHAAN=c.ID_PERUSAHAAN)\n" +
                "LEFT JOIN USERS_GROUP d on a.ID_GROUPS=d.ID_GROUP\n" +
                "\n";

        Sql=toSql.Where(Sql, param,"a", page);
        Sql+=" ORDER  BY a.id DESC ";


        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List rows = query.list();
        return rows;
    }

    public Object getDetail(int id_user)
    {
        String Sql = "SELECT\n" +
                "  a.EMAIL,\n" +
                "  a.ID_PEGAWAI,\n" +
                "  a.JENIS,\n" +
                "  a.ID, \n" +
                "  a.STATUS,\n" +
                "  b.*,\n" +
                "  d.*,\n" +
                "  c.NAMA_PERUSAHAAN\n" +
                "From USERS a\n" +
                "LEFT JOIN PM_PERUSAHAAN_PEGAWAI b on (a.ID_PEGAWAI=b.ID_PERUSAHAAN_PEGAWAI and a.JENIS='p')\n" +
                "LEFT JOIN PM_PERUSAHAAN c on (b.ID_PERUSAHAAN=c.ID_PERUSAHAAN)\n" +
                "LEFT JOIN USERS_GROUP d on a.ID_GROUPS=d.ID_GROUP\n" +
                " WHERE a.id=" + id_user;


        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        query.uniqueResult();
        return query;
    }

    public User getDetailLite(int id_user)
    {
        User user = (User) getSession().get(User.class,id_user);
        return user;
    }

    public User getByUsername(String username)
    {
        User user = (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("name",username))
                .uniqueResult();
        return user;
    }

    public boolean add(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        persist(user);
        return true;
    }

    public boolean edit(User user)
    {
        String pass="";
        if(user.getPassword() != null)
        {
            pass= " PASSWORD ='"+ passwordEncoder.encode(user.getPassword()) + "',\n";
        }
        String Sql = "UPDATE \n" +
                "USERS SET \n" +
                 pass +
                "  EMAIL = '"+ user.getEmail() +"',\n" +
                "  ID_GROUPS="+ user.getId_groups() + "\n" +
                "  \n" +
                "WHERE ID=" + user.getId();

        SQLQuery query = getSession().createSQLQuery(Sql);
        query.executeUpdate();
        return true;
    }

}
