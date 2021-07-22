package com.aemocoding.ws;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getMatch")
public class StringMatchRestController {
	
	@RequestMapping("/text/{text}/subtext/{subText}")
	public List<Integer> matchSubText(@PathVariable String text , @PathVariable String subText){
		// case in-sensitive matching
		// multiple matches
		String lowerCaseText = text.toLowerCase();
		String lowerCaseSubText = subText.toLowerCase();
		List<Integer> indices = new ArrayList<>();
		
		int index = 0;
		while (index != -1) {
			index = lowerCaseText.indexOf(lowerCaseSubText, index);
			if (index != -1) {
				indices.add(index);
				index++;
			}
		}
		return indices;
	}
	

}
