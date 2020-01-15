package com.springboot.car.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SuccessResponse {

	private int code;
	private String message;
	private boolean success;
}
