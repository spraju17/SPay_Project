package com.spraju.spay.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class LoginAPI {
	
	@PostMapping("/userlogin")
	public void userlogin() {
		System.out.println("userRegistration");
	}
	
	
}
