package com.arifin.pm.controller;

import com.arifin.helper.MappingCore;
import com.arifin.pm.dao.perusahaan.Perusahaan_PegawaiDao;
import com.arifin.pm.model.Perusahaan_Pegawai;
import com.arifin.pm.service.PerusahaanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Handy on 09/11/2016.
 */
@RestController
@RequestMapping(value = "pm/perusahaan")
public class Perusahaan_PegawaiCont {
    private final Logger LOG = LoggerFactory.getLogger(Perusahaan_Pegawai.class);

    @Autowired
    private Perusahaan_PegawaiDao perusahaan_pegawaiDao;

    @Autowired
    private PerusahaanService perusahaanService;


    @GetMapping(value = "/{id_perusahaan}/pegawai")
    public ResponseEntity<?> getPegawai(@PathVariable int id_perusahaan){

        List datas = perusahaanService.pegawaiPerusahaan(id_perusahaan);
        MappingCore mappingCore = new MappingCore();
        mappingCore.setDatas(datas);
        mappingCore.setJumlah(datas.size());
        mappingCore.setTotal(datas.size());

        return new ResponseEntity (mappingCore,HttpStatus.OK);
    }


    @GetMapping(value = "/{id_perusahaan}/pegawai_lite")
    public ResponseEntity<?> getPegawaiLite(@PathVariable int id_perusahaan){

        List pegawais = perusahaan_pegawaiDao.getAllLite(id_perusahaan);

        return new ResponseEntity (pegawais,HttpStatus.OK);
    }

    @GetMapping(value = "/{id_perusahaan}/pegawai/{id_perusahaan_pegawai}")
    public ResponseEntity<?> getDetailPegawai(@PathVariable int id_perusahaan_pegawai){

        Perusahaan_Pegawai pegawai =perusahaan_pegawaiDao.getDetailPegawai(id_perusahaan_pegawai);
        if(pegawai !=null)
        {
            return new ResponseEntity (pegawai,HttpStatus.OK);
        }
        return new ResponseEntity ("pegawai tidak ditemukan",HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/{id_perusahaan}/pegawai/add")
    public ResponseEntity<?> addPegawai(@RequestBody Perusahaan_Pegawai perusahaan_pegawai){

        if(perusahaan_pegawaiDao.addPegawai(perusahaan_pegawai))
        {
            return new ResponseEntity (perusahaan_pegawai,HttpStatus.OK);
        }

        return new ResponseEntity ("Gagal Simpan",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/{id_perusahaan}/pegawai/edit/{id_perusahaan_pegawai}")
    public ResponseEntity<?> editPegawai(@RequestBody Perusahaan_Pegawai perusahaan_pegawai){

        if(perusahaan_pegawaiDao.editPegawai(perusahaan_pegawai))
        {
            return new ResponseEntity (perusahaan_pegawai,HttpStatus.OK);
        }

        return new ResponseEntity ("Gagal Simpan",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
