package com.spraju.spay.service;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spraju.spay.utility.LoginCredentials;
import com.spraju.spay.utility.SPayUserDetails;

@Transactional
@Service
public class SPayUserDetailsServiceImpl implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("////////");
		LoginCredentials loginCredentials=new LoginCredentials();
		loginCredentials.setPassword("ff");
		loginCredentials.setEmailId("ff");
		SPayUserDetails sPayUserDetails=new SPayUserDetails(loginCredentials);
		System.out.println(sPayUserDetails.getPassword());
		return sPayUserDetails;
	}

}
