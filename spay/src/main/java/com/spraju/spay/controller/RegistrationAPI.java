package com.spraju.spay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.model.User;
import com.spraju.spay.service.RegistrationService;
import com.spraju.spay.utility.ResponseMessage;


@RestController
@RequestMapping
public class RegistrationAPI {
	
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/userregistration")
	public ResponseEntity<ResponseMessage> userRegistration(@RequestBody User user) throws Exception  {
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(201);
		responseMessage.setResponseMessage(registrationService.userregistration(user));
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.CREATED);
		return responseEntity;
	}

}
