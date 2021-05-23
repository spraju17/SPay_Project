package com.spraju.spay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spraju.spay.model.SecurityQuestion;

@Entity
@Table(name = "SECURITY_QUESTION")
public class SecurityQuestionEntity {
	@Id
	@Column(name = "SECURITY_QUESTION_ID")
	private Integer securityQuestionID;
	@Column(name = "SECURITY_QUESTION")
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
	public static SecurityQuestion prepareSecurityQuestion(SecurityQuestionEntity securityQuestionEntity) {
		SecurityQuestion securityQuestion=new SecurityQuestion();
		securityQuestion.setSecurityQuestionID(securityQuestionEntity.getSecurityQuestionID());
		securityQuestion.setSecurityQuestion(securityQuestionEntity.getSecurityQuestion());
		return securityQuestion;
		
	}
}
