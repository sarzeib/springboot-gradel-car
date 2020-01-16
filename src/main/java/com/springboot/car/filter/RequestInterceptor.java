package com.springboot.car.filter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.car.model.Car;
import com.springboot.car.util.CommonUtil;

@Component
public class RequestInterceptor implements HandlerInterceptor {

	private CommonUtil commonUtil;
	private static final String POST_METHOD = "POST";
	private static final String PUT_METHOD = "PUT";

	@Autowired
	public RequestInterceptor(CommonUtil commonUtil) {
		this.commonUtil = commonUtil;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println(request.getMethod());

		if (request.getMethod().equals(POST_METHOD) || request.getMethod().equals(PUT_METHOD)) {

			InputStream is = request.getInputStream();

			InputStreamReader isReader = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isReader);
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}

			request.setAttribute("carObject", this.getObject(sb.toString()));
		}

		return true;
	}

	private Car getObject(String carObjectString) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		String requestBodyString = commonUtil.decode(carObjectString);
		System.out.println(requestBodyString);

		return mapper.readValue(requestBodyString, Car.class);

	}

}
