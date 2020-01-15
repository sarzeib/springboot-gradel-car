package com.springboot.car.enums;

public enum CodeMessageEnum {

	UNHANDLED_EXCEPTION(1101, "Unhandled Exception Occurred"),
	CITIZEN_NOT_FOUND(1401, "Resource Not Found"),
	
	
	SAVE_SUCCESSFUL(1601, "Car Successfully Saved"),
	UPDATE_SUCCESSFUL(1701, "Car Successfully Updated"),
	DELETE_SUCCESSFUL(1701, "Car Successfully Deleted");
	
	private int errorCode;
	private String errorMsg;
	
	CodeMessageEnum(int errorCode, String errorMsg){
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
