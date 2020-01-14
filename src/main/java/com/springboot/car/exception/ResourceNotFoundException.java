package com.springboot.car.exception;

import com.springboot.car.enums.ErrorMessageEnum;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private ErrorMessageEnum errorMessageEnum;

	public ResourceNotFoundException(ErrorMessageEnum errorMessageEnum){
		this.setErrorMessageEnum(errorMessageEnum);
	}
	
	public ResourceNotFoundException(ErrorMessageEnum errorMessageEnum, Exception e) {
		super(e);
		this.setErrorMessageEnum(errorMessageEnum);
	}

	public ErrorMessageEnum getErrorMessageEnum() {
		return errorMessageEnum;
	}

	public void setErrorMessageEnum(ErrorMessageEnum errorMessageEnum) {
		this.errorMessageEnum = errorMessageEnum;
	}
	
	
}
