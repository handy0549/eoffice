package com.arifin.Acl.Controller;

import com.arifin.Acl.Dao.User_modulDao;
import com.arifin.Acl.Model.User;
import com.arifin.Acl.Model.User_modul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ojiepermana on 12/2/2016.
 */
@RestController
@RequestMapping("/acl/modul")
public class User_modulCont {
    @Autowired
    User_modulDao user_modulDao;

    @GetMapping("")
    public ResponseEntity getAll()
    {
        List<User_modul> user_moduls = user_modulDao.getAll();
        return ResponseEntity.ok(user_moduls);
    }

    @GetMapping("/detail/{id_modul}")
    public ResponseEntity getDetail(@PathVariable int id_modul)
    {
        User_modul modul = user_modulDao.getDetail(id_modul);
        if(modul != null)
        {
            return ResponseEntity.ok(modul);
        }
        return new ResponseEntity("data tidak ditemukan", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody User_modul user_modul)
    {
        user_modulDao.add(user_modul);
        return ResponseEntity.ok(user_modul);
    }
    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody User_modul user_modul)
    {
        user_modulDao.edit(user_modul);
        return ResponseEntity.ok(user_modul);
    }

}
