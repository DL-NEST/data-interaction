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
    //  对数据的增加
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
        savetest.put("运行结果","成功");
        return savetest;
    }
    //    对数据的删除
    @GetMapping(path="/delete")
    public void delete () {
        userrepository.deleteAll();//全删，用了都说好
    }
    //根据主键id查询
    @GetMapping(path="/query")
    public JSONObject cx () {
        JSONObject savetest = new JSONObject();
        savetest.put("运行结果","成功");
        return savetest;
    }
    //根据主键内容id删除
    @GetMapping(path="deleteid")
    public JSONObject deleteid () {
        JSONObject savetest = new JSONObject();
        userrepository.deleteById(14);
        savetest.put("运行结果","成功");
        return savetest;
    }
    //查询到具内容
    @GetMapping(path="/xiugai")
    public JSONObject cg () {
        JSONObject savetest = new JSONObject();
        savetest.put("运行结果",userrepository.findAll().get(0).getUserpassword());
        return savetest;
    }
}
