package com.sachin;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloWorldService {
	
	private String message ;

	@HystrixCommand(fallbackMethod="getFallBackMessage" )
	public String getInfoMessage() {
	//	System.out.println("Your message: " +message);
//		return message;
		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		System.out.println("reached iteminfo");
		//throw new RuntimeException();
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	private String getFallBackMessage() {
		//System.out.println("Your message: " +message);
		return "fallbackmessage";
	}
	

}
