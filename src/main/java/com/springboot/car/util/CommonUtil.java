package com.springboot.car.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

import com.springboot.car.model.Car;

@Component
public class CommonUtil<T> {

	public String encode(T object) {
		T car = object;
		return Base64.getEncoder().encodeToString(car.toString().getBytes());
	}
	
	public String decode(String encodedString) {
		byte[] bytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(bytes);
		return decodedString;
	}
	
	public Car getCar() {
		return Car.builder()
				.brand("Audi")
				.color("white")
				.model("A8")
				.type("All Wheel Drive")
				.build();
	}
	
	public static void main(String[] args) {
		CommonUtil<Car> cutil = new CommonUtil<Car>();
		String encoded = cutil.encode(cutil.getCar());
		
		System.out.println(encoded);
		
	}
	
}
