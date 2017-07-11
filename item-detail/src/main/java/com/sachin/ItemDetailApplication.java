package com.sachin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ItemDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemDetailApplication.class, args);
	}
}
