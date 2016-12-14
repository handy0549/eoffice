package com.arifin.Acl.Controller;

import com.arifin.Acl.Dao.User_aksesDao;
import com.arifin.Acl.Dao.User_modulDao;
import com.arifin.Acl.Model.User_akses;
import com.arifin.Acl.Model.User_modul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ojiepermana on 12/2/2016.
 */

@RestController
@RequestMapping("/acl/level_akses")
public class User_aksesCont {

    
    @Autowired
    User_aksesDao user_aksesDao;

    @Autowired
    User_modulDao user_modulDao;

    @GetMapping("")
    public ResponseEntity getAll()
    {
        List<User_modul> modul = user_modulDao.getAll();
        List<Object> datas = new ArrayList<Object>();
        for (User_modul x:modul)
        {
            List<User_akses> user_aksess = user_aksesDao.getAll(x.getId_modul());
            Map<String,Object> map = new HashMap<>();
            map.put("modul",x);
            map.put("akses",user_aksess);

            datas.add(map);
        }

        return ResponseEntity.ok(datas);
    }

    @GetMapping("/detail/{id_akses}")
    public ResponseEntity add(@PathVariable int id_akses)
    {
        User_akses user_akses = user_aksesDao.getDetail(id_akses);
        if(user_akses != null)
        {
            return ResponseEntity.ok(user_akses);
        }
        return new ResponseEntity("data tidak ditemukan", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody User_akses user_akses)
    {
        user_aksesDao.add(user_akses);
        return ResponseEntity.ok(user_akses);
    }
    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody User_akses user_akses)
    {
        user_aksesDao.edit(user_akses);
        return ResponseEntity.ok(user_akses);
    }
}
