package com.example.heyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class SendinfoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendinfoClientApplication.class, args);
	}

}
