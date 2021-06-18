package com.example.datainteraction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class httpController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}

