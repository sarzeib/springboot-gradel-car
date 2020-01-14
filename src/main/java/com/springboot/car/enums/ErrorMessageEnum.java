package com.springboot.car.enums;

public enum ErrorMessageEnum {

	CITIZEN_NOT_FOUND(1401, "Car Not Found");
	
	private int errorCode;
	private String errorMsg;
	
	ErrorMessageEnum(int errorCode, String errorMsg){
		this.setErrorCode(errorCode);
		this.setErrorMsg(errorMsg);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
