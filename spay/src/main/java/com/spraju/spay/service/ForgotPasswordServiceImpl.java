package com.spraju.spay.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.utility.LoginCredentials;
import com.spraju.spay.utility.PasswordEncryptDecrypt;
import com.spraju.spay.validator.DetailsValidator;

@Service
@Transactional
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
	
	@Autowired
	DetailsValidator detailsValidator;
	
	@Autowired
	PasswordEncryptDecrypt passwordEncryptDecrypt;
	
	@Autowired
	UserDAO userDAO;

	@Override
	public String resetpassword(LoginCredentials loginCredentials) throws Exception {
		if(!detailsValidator.checkEmailFormat.test(loginCredentials.getEmailId()))
			throw new Exception("RegistrationDetailsValidator.INVALID_EMAIL");
		
		String phoneNumberFromDB=userDAO.getPhoneNumberByEmailId(loginCredentials.getEmailId());
		if(phoneNumberFromDB==null)
			throw new Exception("ForgotPassword.EMAILID_NOT_USED");
		if(!loginCredentials.getPhoneNumber().equals(phoneNumberFromDB))
			throw new Exception("ForgotPassword.MOBILE_NUMBER_NOT_USED");
		
		String securityQuestionAnswerFromDB=userDAO.getSecurityQuestionAnswerByEmailId(loginCredentials.getEmailId());
		if(securityQuestionAnswerFromDB.equalsIgnoreCase(loginCredentials.getSecurityQuestionAnswer()))
				userDAO.resetPassword(loginCredentials.getEmailId(),passwordEncryptDecrypt.passwordEncryptor.apply(loginCredentials.getResetPassword()) );
			
		
		return "Password Successfully reseted";
	}

}
