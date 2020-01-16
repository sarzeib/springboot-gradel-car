package com.springboot.car.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	public String encode(String object) {
		String car = object;
		return Base64.getEncoder().encodeToString(car.toString().getBytes());
	}
	
	public String decode(String encodedString) {
		byte[] bytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(bytes);
		return decodedString;
	}
	
}
