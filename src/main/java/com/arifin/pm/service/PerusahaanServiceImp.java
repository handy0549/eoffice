package com.arifin.pm.service;

import com.arifin.pm.dao.PerusahaanDao;
import com.arifin.pm.model.Perusahaan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by etos on 11/2/2016.
 */
@Service
@Transactional
public class PerusahaanServiceImp implements PerusahaanService {

    @Autowired
    private PerusahaanDao perusahaanDao;


//    public Perusahaan getPerusahaanById(int id) {
//        return this.perusahaanDao.findId(id);
//    }
}
