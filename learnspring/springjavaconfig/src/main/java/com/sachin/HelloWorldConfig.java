package com.sachin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {

	@Bean
	public HelloWorldService helloWorld() {
		return new HelloWorldService();
	}
}
