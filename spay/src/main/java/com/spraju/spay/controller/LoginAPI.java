package com.spraju.spay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.service.LoginService;
import com.spraju.spay.utility.LoginCredentials;
import com.spraju.spay.utility.ResponseMessage;


@RestController
@RequestMapping
public class LoginAPI {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/userlogin")
	public ResponseEntity<ResponseMessage> userlogin(@RequestBody LoginCredentials loginCredentials) throws Exception {
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(200);
		responseMessage.setResponseMessage(loginService.userlogin(loginCredentials) + "logged in");
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.OK);
		return responseEntity;
		
	}
	
	
}
