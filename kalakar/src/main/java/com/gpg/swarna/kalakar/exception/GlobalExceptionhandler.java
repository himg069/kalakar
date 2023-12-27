package com.gpg.swarna.kalakar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}
}
