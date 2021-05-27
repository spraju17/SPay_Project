package com.spraju.spay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.SecurityQuestionsDAO;
import com.spraju.spay.entity.SecurityQuestionEntity;
import com.spraju.spay.model.SecurityQuestion;

@Service
@Transactional
public class SecurityQuestionsServiceImpl implements SecurityQuestionsService {
	
	@Autowired
	SecurityQuestionsDAO securityQuestionsDAO;

	@Override
	public List<SecurityQuestion> getSecurityQuestions() {
		 return securityQuestionsDAO.findAll().stream().map(SecurityQuestionEntity::prepareSecurityQuestion).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public String addSecurityQuestions(List<SecurityQuestion> securityQuestions) {
		List<SecurityQuestionEntity> questionEntities=securityQuestions.stream().map(SecurityQuestion::prepareSecurityQuestionEntity).collect(Collectors.toCollection(ArrayList::new));
		securityQuestionsDAO.saveAll(questionEntities);
		return "Sucessfully added";
	}

	@Override
	public String deletSecurityQuestion(Integer securityQuestionId) {
		securityQuestionsDAO.deleteById(securityQuestionId);
		return "Sucessfully deleted";
	}

}
