package com.aemocoding.ws;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class StringMatchRestControllerTest {

	@Test
	void testMatchSubText() {
		String Testtext = " This this a original text from which occurances of subtext need "+
							" to be tested. lets see how many words it can match. This is a Case"
							+ " insensitive Match";
		StringMatchRestController stringCompare = new StringMatchRestController();
		
		// Test for this
		List<Integer> actual = stringCompare.matchSubText(Testtext, "this");
		List<Integer> expected = Arrays.asList(1,6,118);
		assertEquals(expected, actual);
		
		// Test for is
		actual = stringCompare.matchSubText(Testtext, "is");
		expected = Arrays.asList(3,8,120,123);
		assertEquals(expected, actual);
		
		// Test for match
		actual = stringCompare.matchSubText(Testtext, "match");
		expected = Arrays.asList(111);
		assertEquals(expected, actual);	
		
		//Test for noString
		actual = stringCompare.matchSubText(Testtext, "nostring");
		expected = Arrays.asList(-1);
		assertEquals(expected, actual);	
		
	}

}
