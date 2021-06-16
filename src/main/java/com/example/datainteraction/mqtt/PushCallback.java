package com.example.datainteraction.mqtt;

import com.alibaba.fastjson.JSONObject;
import com.example.datainteraction.WebSocket.OneToManyWebSocket;
import com.example.datainteraction.entiy.temperature;
import com.example.datainteraction.repository.Temperaturerepository;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class PushCallback implements MqttCallback {
    @Autowired
    private MqttConfiguration mqttConfiguration;
    @Autowired
    private Temperaturerepository temperaturerepository;

    @Override
    public void connectionLost(Throwable cause) {        // 连接丢失后，一般在这里面进行重连
        log.info("连接断开，正在重连");
        MqttPushClient mqttPushClient = mqttConfiguration.getMqttPushClient();
        if (null != mqttPushClient) {
            mqttPushClient.connect(mqttConfiguration.getHost(), mqttConfiguration.getClientid(), mqttConfiguration.getUsername(),
                    mqttConfiguration.getPassword(), mqttConfiguration.getTimeout(), mqttConfiguration.getKeepalive());
            log.info("已重连");
        }

    }

    /**
     * 发送消息，消息到达后处理方法
     * @param token
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("数据更新完成");
    }

    /**
     * 订阅主题接收到消息处理方法
     * @param topic
     * @param message
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) {
        // subscribe后得到的消息会执行到这里面,这里在控制台有输出
        log.info("接收消息主题:{},Qos:{},接收消息内容:{}", topic, message.getQos(), new String(message.getPayload()));
        if (topic.equals("sys")) {// 有设备接入的时候
            OneToManyWebSocket.sendlogMessage("update");
            JSONObject datas = new JSONObject();
            datas.put("设备名",message);
            OneToManyWebSocket.sendlogMessage(datas.toJSONString());
        } else if (topic.equals("temperature")) {//温度的回调
            JSONObject datas = new JSONObject();
            datas.put("classname","物联网xxx");
            datas.put("温度",new String(message.getPayload()));
            datas.put("time",new Date().toString());
            OneToManyWebSocket.sendlogMessage(datas.toJSONString());// 推送
            temperature temperature = new temperature();
            temperature.setClassname("物联网xxx");// 班级
            temperature.setTemperature(Float.parseFloat(new String(message.getPayload())));// 温度
            temperature.setDatatime1(new Date());   //时间
            temperaturerepository.save(temperature);

        } else if (topic.equals("count")) {
            OneToManyWebSocket.sendlogMessage("通过数：" + message);
        } else if (topic.equals("switch")) {
            OneToManyWebSocket.sendlogMessage("开关：" + message);
        }
    }
//    private void refresh
}