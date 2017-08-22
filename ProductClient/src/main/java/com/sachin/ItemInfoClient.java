package com.sachin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "http://ITEMINFOSERVICE"/*, fallback = ItemInfoClient.ItemInfoServiceFallback.class*/)

//
//Without eureka: name is used to fetch properties from yml.
//@FeignClient(name = "ITEMINFO-SERVICE", fallback = ItemInfoClient.ItemInfoServiceFallback.class)
public interface ItemInfoClient {
	@RequestMapping(method = RequestMethod.GET, value = "/item")
	public String getItem();

	@Component
	public class ItemInfoServiceFallback implements ItemInfoClient {
		@Override
		public String getItem() {
			return "{\"id\":"  + ",\"name\":\"A\",\"category\":\"book\",\"description\":\"desc\","
					+ "\"image\":\"abc.jpg\",\"price\":20.0}";
		}
	}
	
}

