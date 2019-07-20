package com.example.heyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SendinfoRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendinfoRegisterApplication.class, args);
	}

}
