package com.spraju.spay.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.utility.PasswordEncryptDecrypt;
import com.spraju.spay.utility.ResetPassword;
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
	public String resetpassword(ResetPassword resetPassword) throws Exception {
		if(!detailsValidator.checkEmailFormat.test(resetPassword.getEmailID()))
			throw new Exception("RegistrationDetailsValidator.INVALID_EMAIL");
		
		String phoneNumberFromDB=userDAO.getPhoneNumberByEmailId(resetPassword.getEmailID());
		if(phoneNumberFromDB==null)
			throw new Exception("ForgotPassword.EMAILID_NOT_USED");
		if(!resetPassword.getPhoneNumber().equals(phoneNumberFromDB))
			throw new Exception("ForgotPassword.MOBILE_NUMBER_NOT_USED");
		
		
		String securityQuestionAnswerFromDB=userDAO.getSecurityQuestionAnswerByEmailId(resetPassword.getEmailID());
		System.out.println(securityQuestionAnswerFromDB);
		if(securityQuestionAnswerFromDB.equalsIgnoreCase(resetPassword.getSecurityQuestionAnswer()))
			{ 
			userDAO.resetPassword(resetPassword.getEmailID(),PasswordEncryptDecrypt.toHexString(PasswordEncryptDecrypt.getSHA(resetPassword.getResetPassword())));
			return "Password Successfully reseted";
			}
		else
			throw new Exception("ForgotPassword.PASSWORD_RESET_FAILED");
		
		
	}

}
