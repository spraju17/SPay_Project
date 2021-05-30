package com.spraju.spay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.service.ForgotPasswordService;
import com.spraju.spay.utility.LoginCredentials;
import com.spraju.spay.utility.ResetPassword;
import com.spraju.spay.utility.ResponseMessage;

@RestController
@RequestMapping
public class ForgotPasswordAPI {
	
	@Autowired
	ForgotPasswordService forgotPasswordService;
	
	@PostMapping("/forgotpassword")
	public ResponseEntity<ResponseMessage> forgotPassword(@RequestBody ResetPassword resetPassword ) throws Exception {
		
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(200);
		responseMessage.setResponseMessage(forgotPasswordService.resetpassword(resetPassword));
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.OK);
		return responseEntity;
		
		
	}
}
