package com.sachin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.external.ExternalDao;
import com.sachin.dao.HelloWorldDao;

@Service
public class HelloWorldService {

	private String message;

	private HelloWorldDao dao;

	private ExternalDao externalDao;

	@Autowired
	public void setExternalDao(ExternalDao externalDao) {
		this.externalDao = externalDao;
	}

	@Autowired
	public void setDao(HelloWorldDao dao) {
		this.dao = dao;
	}

	public String getMessage() {
		this.dao.getDaoMessage();
		this.externalDao.getDaoMessage();
		System.out.println("Your message: " + message);
		return message;
	}

	public void setMessage(String message) {
		this.dao.setDaoMessage(message);
		this.externalDao.setDaoMessage(message);
		this.message = message;
	}

}
