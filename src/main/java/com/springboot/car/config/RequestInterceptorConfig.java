package com.springboot.car.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.springboot.car.filter.RequestInterceptor;

@Component
public class RequestInterceptorConfig extends WebMvcConfigurationSupport{
	
	@Autowired
	RequestInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}

}
