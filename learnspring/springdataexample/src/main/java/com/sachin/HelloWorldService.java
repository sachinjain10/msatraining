package com.sachin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.external.ExternalDao;
import com.external.jpa.PersonRepository;
import com.sachin.dao.HelloWorldDao;

@Service
public class HelloWorldService {

	private String message;

	private HelloWorldDao dao;

	private ExternalDao externalDao;
	
	private PersonRepository repo;

	public PersonRepository getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(PersonRepository repo) {
		this.repo = repo;
	}

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
		Person fetched= this.repo.findOne(Integer.valueOf(1));
		System.out.println("person from db:" + fetched.getFirstName()+ " "+ fetched.getLastName());
;		System.out.println("Your message: " + message);
		return message;
	}

	public void setMessage(String message) {
		this.dao.setDaoMessage(message);
		this.externalDao.setDaoMessage(message);
		this.message = message;
	}

}
