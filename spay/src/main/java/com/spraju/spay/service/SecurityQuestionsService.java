package com.spraju.spay.service;

import java.util.List;

import com.spraju.spay.model.SecurityQuestion;

public interface SecurityQuestionsService {
	public List<SecurityQuestion> getSecurityQuestions(Integer securityQuestionId);
	
	public String addSecurityQuestions(List<SecurityQuestion> securityQuestions);
	
	public String deletSecurityQuestion(Integer securityQuestionId);
}
