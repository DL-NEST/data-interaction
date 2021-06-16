package com.example.datainteraction.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.datainteraction.entiy.User;
import com.example.datainteraction.repository.Temperaturerepository;
import com.example.datainteraction.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.datainteraction.entiy.temperature;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping(path="/pc")
@RestController
public class PcController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private Temperaturerepository temperaturerepository;

    @RequestMapping(value = "/csh")
    public Object getcsh() {
        JSONObject csh = new JSONObject();
        Object emqx=this.getRestResponse();
        csh.put("emqx",emqx);
        return csh;
    }
    @ResponseBody
    @RequestMapping(value = "/empx")
    public Object getRestResponse() {
        String url = "http://118.31.64.160:8081/api/v4/nodes/emqx@127.0.0.1/stats";
        Map result = restTemplate.getForObject(url, Map.class);
        Object res = result.get("data");
        return JSONObject.toJSONString(res);
    }

    @ResponseBody
    @RequestMapping(value = "/wd")
    public Object wd() {
        List<temperature> wd = temperaturerepository.findAll();
        System.out.print(wd);
        return JSONObject.toJSONString(wd);
    }
    @ResponseBody
    @PostMapping(value = "/add")
    public Object add(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam.toJSONString());//print
        temperature temperature = new temperature();
        temperature.setClassname(jsonParam.get("classname").toString());// 班级
        temperature.setTemperature(Float.parseFloat(jsonParam.get("temperature").toString()));// 温度
        temperature.setDatatime1(new Date());   //时间
        temperaturerepository.save(temperature);
        JSONObject savetest = new JSONObject();
        savetest.put("运行结果","成功");
        return savetest;
    }
    @ResponseBody
    @PostMapping(value = "/del")
    public void colse(@RequestBody JSONObject jsonParam) {
        temperature temperature = new temperature();
        temperaturerepository.deleteAll();
    }

//    @GetMapping(path="/savet")
//    public JSONObject save() {
//        User user = new User();
//        user.setId(2344);
//        user.setUsername("王五");
//        user.setUserphone("1244241535");
//        user.setUserpassword("dgagqeag");
//        user.setDatatime(new Date());
//        userrepository.save(user);
//        JSONObject savetest = new JSONObject();
//        savetest.put("运行结果", "成功");
//        return savetest;
//    }
//    @RequestMapping(value = "/test1")
//    private String get() {
//        OneToManyWebSocket.s
//    }
}