package com.spraju.spay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.service.JWTUtil;
import com.spraju.spay.service.SPayUserDetailsServiceImpl;
import com.spraju.spay.utility.JWTCredentials;
import com.spraju.spay.utility.JWTResponse;

@RestController
@RequestMapping("/jwtauthenticate")
public class JWTAuthenticateAPI {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	SPayUserDetailsServiceImpl sPayUserDetailsServiceImpl;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@PostMapping
	public ResponseEntity<JWTResponse> jwtAuthenticate(@RequestBody JWTCredentials jwtCredentials) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtCredentials.getUsername(), jwtCredentials.getPassword()));
		UserDetails userDetails=sPayUserDetailsServiceImpl.loadUserByUsername(jwtCredentials.getUsername());
		String jwt=jwtUtil.generateToken(userDetails);
		JWTResponse jwtResponse=new JWTResponse();
		jwtResponse.setJwt(jwt);
		return ResponseEntity.ok(jwtResponse);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
