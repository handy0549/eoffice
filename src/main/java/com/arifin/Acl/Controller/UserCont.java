package com.arifin.Acl.Controller;

import com.arifin.Acl.Dao.UserDao;
import com.arifin.Acl.Model.User;
import com.arifin.helper.MappingCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ojiepermana on 12/2/2016.
 */
@RestController
@RequestMapping("/acl/user")
public class UserCont {

    @Autowired
    UserDao userDao;

    @GetMapping("")
    public ResponseEntity getAll(@RequestParam Map<String,String> param)
    {
        List TOTAL = userDao.getAll(param,false);
        List datas = userDao.getAll(param,true);
        MappingCore obj = new MappingCore();

        obj.setDatas(datas);
        obj.setJumlah(datas.size());
        obj.setTotal(TOTAL.size());
        obj.setParam(param);

        return ResponseEntity.ok(obj);
    }

    @GetMapping("/detail/{id_user}")
    public ResponseEntity getDetail(@PathVariable int id_user)
    {
        Object user = userDao.getDetail(id_user);
        if(user !=null)
        {
            return ResponseEntity.ok(user);
        }
        return  new ResponseEntity("data tidak ditemukan", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/detail_lite/{id_user}")
    public ResponseEntity getDetailLite(@PathVariable int id_user)
    {
        User user = userDao.getDetailLite(id_user);
        if (user !=null)
        {
            user.setPassword("");
            return new ResponseEntity(user,HttpStatus.OK);
        }
        return new ResponseEntity("data tidak ditemukan",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody User user)
    {
        Map<String,String> pesan = new HashMap<>();

        if(user.getPassword().length() < 3 && user.getName().length() < 3)
        {
            pesan.put("status","gagal");
            pesan.put("pesan","Data Tidak lengkap");
            return new ResponseEntity(pesan,HttpStatus.OK);
        }

        //cek username ado apo olun
        if(userDao.getByUsername(user.getName()) != null)
        {
            if(userDao.add(user))
            {
                pesan.put("status","ok");
                pesan.put("pesan","Username Sudah disimpan");
            }
            else
            {
                pesan.put("status","gagal");
                pesan.put("pesan","gagal Simpan");
            }

        }
        else
        {
            pesan.put("status","gagal");
            pesan.put("pesan","Username Sudah digunakan");
        }



        return new ResponseEntity(pesan,HttpStatus.OK);
    }
    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody User user)
    {
        Map<String,String> pesan = new HashMap<>();

        if(user.getName().length() < 3)
        {
            pesan.put("status","gagal");
            pesan.put("pesan","Data Tidak lengkap");
            return new ResponseEntity(pesan,HttpStatus.OK);
        }

        if(userDao.edit(user))
        {
            pesan.put("status","ok");
            pesan.put("pesan","Username Sudah diPerbarui");
        }
        else
        {
            pesan.put("status","gagal");
            pesan.put("pesan","gagal Simpan");
        }

        return new ResponseEntity(pesan,HttpStatus.OK);
    }


}
