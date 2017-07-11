package com.sachin;

public class HelloWorldService {
	
	private String message ;

	public String getMessage() {
		System.out.println("Your message: " +message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
