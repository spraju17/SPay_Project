package com.spraju.spay.validator;

import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.spraju.spay.model.Address;
import com.spraju.spay.model.Card;
import com.spraju.spay.model.User;
import com.spraju.spay.utility.LoginCredentials;

@Component
public class DetailsValidator {
	
	public Predicate<String> checkEmailFormat=(email)->email.matches("[A-z0-9][^@]{3,62}[A-z0-9]@[A-z0-9.-]{3,10}.(com|in|org|net)");
	
	public Predicate<String> checkNameFormat=(name)->name.matches("[A-z][A-z ]{1,25}") && !name.matches("[  ]+");
	
	public Predicate<String> checkPhoneNumberFormat=(number)->number.matches("[1-9][0-9]{9}");
	
	public Predicate<String> checkPasswordFormat=(password)->password.matches(".{8,20}") && password.matches(".*[A-Z].*")
			&& password.matches(".*[a-z].*")  && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*(+_)].*");
	
	public Predicate<String> checkCardNumber=(number)->number.matches("[1-9][0-9]{4}");
	
	public Predicate<String> checkCardCVV=(cvv)->cvv.matches("[1-9][0-9]{2,3}");
	
	public Predicate<String> checkZipCode=(zipcode)->zipcode.matches("[1-9][0-9]{5}");
	
	public Predicate<String> checkAddressElements=(addressElement)->addressElement.matches("[A-z]{2,20}");
	
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
	
	public void loginCredentialsValidator(LoginCredentials loginCredentials) throws Exception {
		if(!checkPasswordFormat.test(loginCredentials.getPassword()))
			throw new Exception("Login.INVALID_CREDENTIALS");
		if(!checkEmailFormat.test(loginCredentials.getEmailId()))
			throw new Exception("Login.INVALID_CREDENTIALS");
	}
	
	public void userCardValidator(Card card) throws Exception {
			if(!checkCardCVV.test(Integer.toString(card.getCvv())))
				throw new Exception("UserCard.INVALID_CVV");
			if(!checkCardNumber.test(Integer.toString(card.getCardNumber())))
				throw new Exception("UserCard.INVALID_CARD_NUMBER");
		}
	
	public void userAddressValidator(Address address) throws Exception {
		if(!checkZipCode.test(Integer.toString(address.getZipCode())))
				throw new Exception("AddressValidator_INVALID_ZIPCODE");
		if(!checkAddressElements.test(address.getCity()) || !checkAddressElements.test(address.getCountry())
				|| !checkAddressElements.test(address.getDistrict()) || !checkAddressElements.test(address.getState()))
			throw new Exception("AddressValidator_INVALID_ADDRESS");
	}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

