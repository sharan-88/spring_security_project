package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
//   servlet contains
//   request passes through filter chain ,front controller , controllers
//spring security is present in filter chain
// some of filters are security contextPersistanceFilter logoutFilter ,usernamepasswordathenticate filter
// we can customize these features
// it works it chain format
// we can change the req and res before reaching controller or before sending to frontend
//by default it give password and user name as user
// we can use our name and password by spring.security.user.--- and set value in resources/application.properties


//CIRF
//CROSS CITE REQUEST FORGIERY

