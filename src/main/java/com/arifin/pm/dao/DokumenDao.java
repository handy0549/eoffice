package com.arifin.pm.dao;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Dokumen;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class DokumenDao extends AbstractDao<Integer,Dokumen>{

    public List<Object[]> getAll() {
        return null;
    }

    public List<Dokumen> getList(int jenis,int id_param) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dokumen_untuk",jenis));
        criteria.add(Restrictions.eq("id_param",id_param));
        return (List<Dokumen>) criteria.list();
    }

    public Boolean add(Dokumen dokumen)
    {
        persist(dokumen);
        return true;
    }

    public Boolean edit(Dokumen dokumen)
    {
        update(dokumen);
        return true;
    }
}
