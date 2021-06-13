package com.example.datainteraction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/login")
public class LoginController {
//    @Autowired
    @PostMapping("/log")
    public String Login(@RequestParam String username,
                        @RequestBody String password){
        return "OK";
    }
    @GetMapping("test")
    public String test2(){
        return "FEEWGV";
    }
}
