package com.arifin.helper;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Perusahaan;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ojiepermana on 11/18/2016.
 */
@Component
@Transactional
public class QueryHelp extends AbstractDao<Integer,Perusahaan> {

    public Object GetCount(String table,String get, String as, int whereId)
    {
        String Sql ="SELECT count(" + get +")  as " + as +
                " From "+ table + " " +
                " where id_kontraktor = " + whereId;
        SQLQuery query = getSession().createSQLQuery(Sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        return query.uniqueResult();
    }

    public int getIdUser()
    {
        return 1;
    }
}
