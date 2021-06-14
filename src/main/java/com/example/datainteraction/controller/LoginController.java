package com.example.datainteraction.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@ResponseBody
@RequestMapping(path="/login",produces = "application/json;charset=UTF-8")
public class LoginController {
//    @Autowired
    @PostMapping("/log")
    public String Login(@RequestBody JSONObject jsonParam){
        // 直接将json信息打印出来
        System.out.println(jsonParam.toJSONString());
        System.out.println(jsonParam.get("username"));

        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "json");
        result.put("data", jsonParam);

        return result.toJSONString();
    }
    @GetMapping("test")
    public String test2(){
        String a = "efq";
        return a;
    }
}
