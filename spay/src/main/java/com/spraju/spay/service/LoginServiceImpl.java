package com.spraju.spay.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.utility.LoginCredentials;
import com.spraju.spay.utility.PasswordEncryptDecrypt;
import com.spraju.spay.validator.DetailsValidator;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	DetailsValidator detailsValidator;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	PasswordEncryptDecrypt passwordEncryptDecrypt;

	@Override
	public Integer userlogin(LoginCredentials loginCredentials) throws Exception {
		detailsValidator.loginCredentialsValidator(loginCredentials);
		List<Object[]> passwordAndUserid = userDAO.getPasswordByEmailId(loginCredentials.getEmailId());
		String passwordFromDB=(String) passwordAndUserid.get(0)[0];
		if(BCrypt.checkpw(loginCredentials.getPassword(), passwordFromDB))
		{
			return (Integer) passwordAndUserid.get(0)[1];
		}
		else
			throw new Exception("Login.INVALID_CREDENTIALS");
		
	}

}
