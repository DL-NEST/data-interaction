package com.example.datainteraction.mqtt;

import com.example.datainteraction.WebSocket.OneToManyWebSocket;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PushCallback implements MqttCallback {
    @Autowired
    private MqttConfiguration mqttConfiguration;

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
        if (topic.equals("sys")) {
            OneToManyWebSocket.sendlogMessage("设备：" + message);
        } else if (topic.equals("temperature")) {
            OneToManyWebSocket.sendlogMessage("温度：" + message);
        } else if (topic.equals("count")) {
            OneToManyWebSocket.sendlogMessage("通过数：" + message);
        } else if (topic.equals("switch")) {
            OneToManyWebSocket.sendlogMessage("开关：" + message);
        }
    }
//    private void refresh
}