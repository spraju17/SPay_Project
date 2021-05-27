package com.spraju.spay.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> handleexception(Exception exception){
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(400);
		responseMessage.setResponseMessage(exception.getMessage());
		return new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.BAD_REQUEST);
		
	}
}
