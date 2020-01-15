package com.springboot.car.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.car.bean.ErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ErrorResponse> handleUnhandledException(final BaseException exception) {
		return ResponseEntity.badRequest().body(this.buildErrorResponse(exception.getErrorMessageEnum().getErrorCode(),
				exception.getErrorMessageEnum().getErrorMsg()));
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(final ResourceNotFoundException exception) {
		return ResponseEntity.badRequest().body(this.buildErrorResponse(exception.getErrorMessageEnum().getErrorCode(),
				exception.getErrorMessageEnum().getErrorMsg()));
	}

	private ErrorResponse buildErrorResponse(int errorCode, String errorMessage) {
		return ErrorResponse.builder().code(errorCode).message(errorMessage).build();
	}

}
