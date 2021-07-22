package com.aemocoding.consume;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StringMatchConsumer {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/getIndices")
	public ArrayList<?> getIndices() {
		String text = "hello Howare youhello Howareyou";
		String subtext = "how";
		return restTemplate.getForObject("http://localhost:8080/getMatch/text/"+text+"/subtext/"+subtext, ArrayList.class);
	}

}
