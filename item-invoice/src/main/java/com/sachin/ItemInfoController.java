package com.sachin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemInfoController {
	
	@Autowired
	private HelloWorldService helloWorldService;
	

	@RequestMapping(method = RequestMethod.GET, value = "/itemdetail")
	public String getItem() {
		System.out.println("service: "+ helloWorldService);
		helloWorldService.getDetailMessage();
		return helloWorldService.getDetailMessage();

	}

}
