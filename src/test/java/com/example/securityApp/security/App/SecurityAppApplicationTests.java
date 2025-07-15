package com.example.securityApp.security.App;

import com.example.securityApp.security.App.Entity.User;
import com.example.securityApp.security.App.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityAppApplicationTests {

	@Autowired
	private JwtService service;

	@Test
	void contextLoads() {
		User user=new User(4L,"Pallu@gmail","1234");

		String token=service.generateToken(user);
		System.out.println(token);
	}

}
