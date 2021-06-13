package com.example.datainteraction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @PostMapping("/log")
    public String Login(@RequestBody String username,
                        @RequestBody String password){
        return "OK";
    }
}

