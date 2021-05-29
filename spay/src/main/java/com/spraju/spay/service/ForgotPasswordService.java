package com.spraju.spay.service;

import com.spraju.spay.utility.LoginCredentials;

public interface ForgotPasswordService  {
	public String resetpassword(LoginCredentials loginCredentials) throws Exception;

}
