package com.lihao.diancaisystem;

import com.lihao.diancaisystem.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiancaisystemApplicationTests {

	@Resource
	UserService userService;

	@Test
	public void contextLoads() {
		System.out.println(userService.selectUser());
	}

}
