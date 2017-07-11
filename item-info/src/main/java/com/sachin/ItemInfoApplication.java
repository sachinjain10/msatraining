package com.sachin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ItemInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemInfoApplication.class, args);
	}
}
