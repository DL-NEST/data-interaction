package com.example.datainteraction;

import com.example.datainteraction.entiy.User;
import com.example.datainteraction.repository.Userrepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Id;

@SpringBootTest
class DataInteractionApplicationTests {
	@Autowired		//自动导入配置
	private Userrepository userrepository;		//映射配置
	@Test
	void contextLoads() {
		System.out.println(userrepository.findAll());
//		User uu=new User();
//		System.out.println(uu.getId());
	}
}
