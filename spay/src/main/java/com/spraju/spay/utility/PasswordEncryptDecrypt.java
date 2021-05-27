package com.spraju.spay.utility;

import java.util.function.Function;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptDecrypt {
	
	public Function<String, String> passwordEncryptor=(password)->BCrypt.hashpw(password, BCrypt.gensalt());
	
	

}
