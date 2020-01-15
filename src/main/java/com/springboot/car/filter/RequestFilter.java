package com.springboot.car.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springboot.car.model.Car;
import com.springboot.car.util.CommonUtil;

@Component
public class RequestFilter extends OncePerRequestFilter{

	private CommonUtil<Car> commonUtil;
	
	@Autowired
	RequestFilter(CommonUtil<Car> commonUtil){
		this.commonUtil = commonUtil;
	}
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String line = null;
		StringBuffer buffer = new StringBuffer();
		
		try {
			
			BufferedReader reader = request.getReader();
			while((line = reader.readLine())!= null) {
				buffer.append(line);
			}
		}catch(Exception e) {
			System.out.println("Exception occurred while reading request");
		}
		
		System.out.println(commonUtil.decode(buffer.toString()));
		
		
		filterChain.doFilter(request, response);
		
	}

}
