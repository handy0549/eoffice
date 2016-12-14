package com.arifin.pm.dao.perusahaan;

import com.arifin.abstrac.AbstractDao;
import com.arifin.pm.model.Perusahaan_jabatan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ojiepermana on 12/3/2016.
 */
@Transactional
@Component
public class Perusahaan_jabatanDao extends AbstractDao<Integer,Perusahaan_jabatan> {

    public List<Perusahaan_jabatan> getAll()
    {
        List<Perusahaan_jabatan> perusahaan_jabatens = getSession().createCriteria(Perusahaan_jabatan.class).list();
        return perusahaan_jabatens;
    }
}
