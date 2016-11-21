package com.arifin.pm.service;

import com.arifin.pm.dao.perusahaan.PerusahaanDao;
import com.arifin.pm.dao.perusahaan.Perusahaan_PegawaiDao;
import com.arifin.pm.model.Perusahaan_Pegawai;
import com.arifin.pm.model.Perusahaan_jabatan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by etos on 11/2/2016.
 */
@Service
@Transactional
@Component
public class PerusahaanService {

    @Autowired
    Perusahaan_PegawaiDao perusahaan_pegawaiDao;

    public List pegawaiPerusahaan(int id_perusahaan)
    {
        List<Object[]> datas = perusahaan_pegawaiDao.getAll(id_perusahaan);
        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] x:datas)
        {
            Perusahaan_Pegawai pegawai = (Perusahaan_Pegawai) x[0];
            Perusahaan_jabatan jabatan= (Perusahaan_jabatan) x[1];

            Map<String,Object > map = new HashMap<>();
            map.put("pegawai",pegawai);
            map.put("jabatan",jabatan);

            out.add(map);
        }

        return out;

    }
}
