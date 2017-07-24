package com.sachin;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloWorldService {
	
	private String message ;

	@HystrixCommand(fallbackMethod="getFallBackMessage" )
	public String getMessage() {
	//	System.out.println("Your message: " +message);
//		return message;
		throw new RuntimeException();
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	private String getFallBackMessage() {
		//System.out.println("Your message: " +message);
		return "fallbackmessage";
	}
	

}
