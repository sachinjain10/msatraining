package com.sachin.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldDao {
	
	private String daoMessage;

	public String getDaoMessage() {
		System.out.println("My dao message: " + daoMessage);
		return daoMessage;
	}

	public void setDaoMessage(String daoMessage) {
		this.daoMessage = daoMessage;
	}
	

}
