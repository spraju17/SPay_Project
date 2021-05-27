package com.spraju.spay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.model.User;
import com.spraju.spay.service.UserProfileService;

@RestController
@RequestMapping
public class UserProfileAPI {
	
	@Autowired
	UserProfileService userProfileService;
	
	@GetMapping("/userprofile/{userid}")
	public ResponseEntity<User> getuserprofiledtails(@PathVariable Integer userid) throws Exception{
		User user=userProfileService.getUserProfileDetaials(userid);
		System.out.println(user);
		ResponseEntity<User> responseEntity=new ResponseEntity<User>(user,HttpStatus.OK);
		return responseEntity;
	}
}
