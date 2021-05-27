package com.spraju.spay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.model.SecurityQuestion;
import com.spraju.spay.service.SecurityQuestionsService;
import com.spraju.spay.utility.ResponseMessage;

@RestController
@RequestMapping
@CrossOrigin
public class SecurityQuestionAPI {
	
	@Autowired
	SecurityQuestionsService securityQuestionsService;
	
	@GetMapping("/securityquestions")
	public ResponseEntity<List<SecurityQuestion>> getSecurityQuestions(){
		return new ResponseEntity<List<SecurityQuestion>>(securityQuestionsService.getSecurityQuestions(),HttpStatus.OK);    
	}
	
	@PostMapping("/securityquestions")
	public ResponseEntity<ResponseMessage> addSecurityQuestions(@RequestBody List<SecurityQuestion> securityQuestions){
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(201);
		responseMessage.setResponseMessage(securityQuestionsService.addSecurityQuestions(securityQuestions));
		return new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.CREATED);
					
	}
	
	@DeleteMapping(("/securityquestions/{securityQuestionId}"))
	public ResponseEntity<ResponseMessage> deleteSecurityQuestion(@PathVariable Integer securityQuestionId){
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(200);
		responseMessage.setResponseMessage(securityQuestionsService.deletSecurityQuestion(securityQuestionId));
		return new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.OK);
	}
}
