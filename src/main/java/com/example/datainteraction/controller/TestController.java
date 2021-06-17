package com.example.datainteraction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
        return "index";
    }


//    @RequestMapping(value = "/test1")
//    private String get() {
//        OneToManyWebSocket.s
//    }
}

