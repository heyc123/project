package com.example.heyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class SendinfoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendinfoServerApplication.class, args);
	}

}
