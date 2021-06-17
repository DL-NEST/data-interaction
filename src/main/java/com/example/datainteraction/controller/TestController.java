package com.example.datainteraction.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.datainteraction.WebSocket.OneToManyWebSocket;

import java.util.Map;

@Controller
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/test")
    public Object getRestResponse() {
        String url = "http://118.31.64.160:8081/api/v4/nodes/emqx@127.0.0.1/stats";
        Map result = restTemplate.getForObject(url, Map.class);
        Object res = result.get("data");
        return res;
    }
    @RequestMapping("/static")
    public String test2(){
        return "/test";
    }


//    @RequestMapping(value = "/test1")
//    private String get() {
//        OneToManyWebSocket.s
//    }
}

