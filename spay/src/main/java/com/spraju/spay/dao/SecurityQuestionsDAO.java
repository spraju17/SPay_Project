package com.spraju.spay.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spraju.spay.entity.SecurityQuestionEntity;

public interface SecurityQuestionsDAO extends JpaRepository<SecurityQuestionEntity, Integer> {
	
}
