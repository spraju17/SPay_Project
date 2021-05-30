package com.spraju.spay.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.utility.LoginCredentials;
import com.spraju.spay.utility.PasswordEncryptDecrypt;
import com.spraju.spay.utility.SPayUserDetails;

@Transactional
@Service
public class SPayUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDAO userDAO;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SPayUserDetails sPayUserDetails;
		try {
			System.out.println(username);
			List<Object[]> passwordAndUserid = userDAO.getPasswordandUserIDByEmailId(username);
			
			LoginCredentials loginCredentials=new LoginCredentials();
			
			loginCredentials.setPassword( (String) passwordAndUserid.get(0)[0]);
			
			System.out.println(loginCredentials.getPassword());
			loginCredentials.setEmailId(username);
			sPayUserDetails = new SPayUserDetails(loginCredentials);
			return sPayUserDetails;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

}
