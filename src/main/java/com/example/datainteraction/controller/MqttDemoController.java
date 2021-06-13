package com.example.datainteraction.controller;

import com.example.datainteraction.mqtt.MqttPushClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Dong
 * @Date：2020/8/26 16:12
 */
@RestController
@RequestMapping("mqttDemo")
public class MqttDemoController {
    @Autowired
    private MqttPushClient mqttPushClient;
    /**
     * 通过MqttPushClient类publish方法的发送"这是一条测试消息"到名为"test_queue"的主题，如果需要拿到这条消息，
     * 需要在MqttSubClient类的subScribeDataPublishTopic方法进行配置和订阅该主题（这个DEMO已经配置好,并在连接mqtt服务器时就已经订阅），
     * 配置完成后 PushCallBack类的messageArrived方法会接收到已订阅主题接收到的消息(订阅主题后可以在该方法中处理接收到的消息)
     *
     */
    @RequestMapping("testPublishMessage1")
    public void testPublishMessage() {
        mqttPushClient.publisha("test_queue","这是一条测试消息");
    }

    @RequestMapping("testPublishMessage2")
    public void testPublishMessage2(String message){
        mqttPushClient.publisha("test_queue",message);
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}