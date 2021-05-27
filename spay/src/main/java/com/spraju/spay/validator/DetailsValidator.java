package com.spraju.spay.validator;

import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.spraju.spay.model.User;

@Component
public class DetailsValidator {
	
	public Predicate<String> checkEmailFormat=(email)->email.matches("[A-z0-9][^@]{3,62}[A-z0-9]@[A-z0-9.-]{3,10}.(com|in|org|net)");
	
	public Predicate<String> checkNameFormat=(name)->name.matches("[A-z][A-z ]{1,25}") && !name.matches("[  ]+");
	
	public Predicate<String> checkPhoneNumberFormat=(number)->number.matches("[1-9][0-9]{9}");
	
	public Predicate<String> checkPasswordFormat=(password)->password.matches(".{8,20}") && password.matches(".*[A-Z].*")
			&& password.matches(".*[a-z].*")  && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*(+_)].*");
	
	public void registrationDetailsValidator(User user) throws Exception {
		if(!checkEmailFormat.test(user.getEmailId()))
			throw new Exception("RegistrationDetailsValidator.INVALID_EMAIL");
		if(!checkNameFormat.test(user.getName()))
			throw new Exception("RegistrationDetailsValidator.INVALID_NAME");
		if(!checkPhoneNumberFormat.test( String.valueOf(user.getPhoneNumber())))
			throw new Exception("RegistrationDetailsValidator.INVALID_NUMBER");
		if(!checkPasswordFormat.test(user.getPassword()))
			throw new Exception("RegistrationDetailsValidator.INVALID_PASSWORD");
		
	}
}
