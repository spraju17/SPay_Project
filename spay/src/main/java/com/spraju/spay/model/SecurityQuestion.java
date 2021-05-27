package com.spraju.spay.model;

import com.spraju.spay.entity.SecurityQuestionEntity;

public class SecurityQuestion {
	private Integer securityQuestionID;
	private String securityQuestion;
	public Integer getSecurityQuestionID() {
		return securityQuestionID;
	}
	public void setSecurityQuestionID(Integer securityQuestionID) {
		this.securityQuestionID = securityQuestionID;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	public static SecurityQuestionEntity prepareSecurityQuestionEntity(SecurityQuestion securityQuestion) {
		SecurityQuestionEntity securityQuestionEntity=new SecurityQuestionEntity();
		securityQuestionEntity.setSecurityQuestionID(securityQuestion.getSecurityQuestionID());
		securityQuestionEntity.setSecurityQuestion(securityQuestion.getSecurityQuestion());
		return securityQuestionEntity;
		
	}

}
