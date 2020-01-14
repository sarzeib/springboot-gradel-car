package com.springboot.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.springboot"})
public class SpringbootGradleCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGradleCarApplication.class, args);
	}

}
