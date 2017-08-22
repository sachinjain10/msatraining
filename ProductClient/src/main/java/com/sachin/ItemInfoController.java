package com.sachin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemInfoController {
	
	@Autowired
	private ItemInfoClient client;
	
	@Autowired
	private Sender sender;
	
	@RequestMapping(method = RequestMethod.GET, value = "/product")
	public String getItem() {
		System.out.println("service: ");
		sender.send("sample message");
		client.getItem();
		return client.getItem();

	}

}
