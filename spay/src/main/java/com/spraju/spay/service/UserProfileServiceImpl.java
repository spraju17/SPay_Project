package com.spraju.spay.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.entity.UserEntity;
import com.spraju.spay.model.User;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public User getUserProfileDetaials(Integer userId) throws Exception {
		
		Optional<UserEntity> userEntity=userDAO.findById(userId);
		if(userEntity.isEmpty())
			throw new Exception("Login.INVALID_USERID");
		User user=UserEntity.prepareUser(userEntity.get());
		return user;	
	}

}
