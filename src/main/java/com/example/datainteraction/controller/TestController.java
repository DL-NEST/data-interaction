package com.example.datainteraction.controller;

import cn.hutool.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/test")
    private Object getRestResponse() {
        String url = "http://118.31.64.160:8081/api/v4/nodes/emqx@127.0.0.1/stats";
        Map<String,Object>result = restTemplate.getForObject(url, Map.class);
        System.out.print(result.get("data"));
        return result.get("data");
    }
}

