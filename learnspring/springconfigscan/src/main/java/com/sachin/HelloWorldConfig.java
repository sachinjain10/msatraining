package com.sachin;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sachin,com.external")
public class HelloWorldConfig {

}
