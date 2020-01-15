package com.springboot.car.exception;

import com.springboot.car.enums.CodeMessageEnum;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private CodeMessageEnum errorMessageEnum;

	public BaseException(CodeMessageEnum errorMessageEnum) {
		this.setErrorMessageEnum(errorMessageEnum);
	}

	public BaseException(CodeMessageEnum errorMessageEnum, Exception e) {
		super(e);
		this.setErrorMessageEnum(errorMessageEnum);
	}

	public CodeMessageEnum getErrorMessageEnum() {
		return errorMessageEnum;
	}

	public void setErrorMessageEnum(CodeMessageEnum errorMessageEnum) {
		this.errorMessageEnum = errorMessageEnum;
	}

}
