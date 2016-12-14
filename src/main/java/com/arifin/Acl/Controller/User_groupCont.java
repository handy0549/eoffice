package com.arifin.Acl.Controller;

import com.arifin.Acl.Dao.User_groupDao;
import com.arifin.Acl.Model.User_group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ojiepermana on 12/2/2016.
 */
@RestController
@RequestMapping("/acl/group")
public class User_groupCont {

    @Autowired
    User_groupDao user_groupDao;

    @GetMapping("")
    public ResponseEntity getAll()
    {
        List<User_group> user_groups = user_groupDao.getAll();
        return ResponseEntity.ok(user_groups);
    }

    @GetMapping("/detail/{id_group}")
    public ResponseEntity add(@PathVariable int id_group)
    {
        User_group user_group = user_groupDao.getDetail(id_group);
        if(user_group != null)
        {
            return ResponseEntity.ok(user_group);
        }
        return new ResponseEntity("data tidak ditemukan", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody User_group user_group)
    {
        user_groupDao.add(user_group);
        return ResponseEntity.ok(user_group);
    }
    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody User_group user_group)
    {
        user_groupDao.edit(user_group);
        return ResponseEntity.ok(user_group);
    }
}
