package com.spraju.spay.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.entity.UserEntity;
import com.spraju.spay.model.AccountStatus;
import com.spraju.spay.model.TierLevel;
import com.spraju.spay.model.User;
import com.spraju.spay.model.UserRole;
import com.spraju.spay.utility.PasswordEncryptDecrypt;
import com.spraju.spay.validator.DetailsValidator;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	DetailsValidator detailsValidator;
	
	@Autowired
	PasswordEncryptDecrypt passwordEncryptDecrypt;
	
	@Autowired
	UserDAO userDAO;
	

	@Override
	public String userregistration(User user) throws Exception {
		detailsValidator.registrationDetailsValidator(user);
		String phonenumber=userDAO.getPhoneNumberByEmailId(user.getEmailId());
		if(phonenumber!=null)
			throw new Exception("RegitrationDetails.EMAILID_ALREADY_USED");
		if(user.getPhoneNumber().equalsIgnoreCase(phonenumber))
			throw new Exception("RegitrationDetails.MOBILE_NUMBER_ALREADY_USED");
		user.setTierLevel(TierLevel.ONE);
		user.setAccountStatus(AccountStatus.ACTIVE);
		user.setUserRole(UserRole.ADMIN);
		user.setPassword(passwordEncryptDecrypt.passwordEncryptor.apply(user.getPassword()));
		UserEntity userEntity=User.prepareUserEntity(user);
		userDAO.save(userEntity);
		return "Sucessfully added";
		
		
	}

}
