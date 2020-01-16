package com.springboot.car.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springboot.car.bean.ErrorResponse;
import com.springboot.car.enums.CodeMessageEnum;

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

	@ExceptionHandler(JsonMappingException.class)
	public ResponseEntity<ErrorResponse> handleJsonMappingException(final JsonMappingException exception) {
		return ResponseEntity.badRequest()
				.body(this.buildErrorResponse(CodeMessageEnum.JSON_MAPPING_EXCEPTION.getErrorCode(),
						CodeMessageEnum.JSON_MAPPING_EXCEPTION.getErrorMsg()));
	}

	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<ErrorResponse> handleJsonProcessingException(final JsonProcessingException exception) {
		return ResponseEntity.badRequest()
				.body(this.buildErrorResponse(CodeMessageEnum.JSON_PROCESSING_EXCEPTION.getErrorCode(),
						CodeMessageEnum.JSON_PROCESSING_EXCEPTION.getErrorMsg()));
	}

	private ErrorResponse buildErrorResponse(int errorCode, String errorMessage) {
		return ErrorResponse.builder().code(errorCode).message(errorMessage).build();
	}

}
