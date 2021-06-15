package com.example.datainteraction.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.datainteraction.entiy.User;
import com.example.datainteraction.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/data")
public class UserController {
    @Autowired
    private Userrepository userrepository;

    @GetMapping(path="/login")
    public List<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userrepository.findAll();
    }

    @GetMapping(path="/cc")
    public String hello() {
        return "test";
    }

    @GetMapping(path="/save")
    public JSONObject save() {
        User user = new User();
        user.setId(2344);
        user.setUsername("王五");
        user.setUserphone("1244241535");
        user.setUserpassword("dgagqeag");
        user.setDatatime(new Date());
        userrepository.save(user);
        JSONObject savetest = new JSONObject();
        savetest.put("path",userrepository.findById(2567).get().getUsername());
        return savetest;
    }
}
