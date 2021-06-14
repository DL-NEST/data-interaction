package com.example.datainteraction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
class DataInteractionApplicationTests {
	@Autowired		//自动导入配置
	RestTemplate restTemplate;
	@Test
	private Object getRestResponse() {
		String url = "http://118.31.64.160:8081/api/v4/nodes/emqx@127.0.0.1/stats";
		Map result = restTemplate.getForObject(url, Map.class);
		Object res = result.get("data");
//        jsonObject.getString("subscribers.count");
//        System.out.println(jsonObject.getString("subscribers.count"));
		return res;
	}
}
