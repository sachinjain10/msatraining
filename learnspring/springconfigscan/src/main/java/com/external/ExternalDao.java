package com.external;

import org.springframework.stereotype.Repository;

@Repository
public class ExternalDao {
	
	private String daoMessage;

	public String getDaoMessage() {
		System.out.println("My externaldao message: " + daoMessage);
		return daoMessage;
	}

	public void setDaoMessage(String daoMessage) {
		this.daoMessage = daoMessage;
	}
	


}
