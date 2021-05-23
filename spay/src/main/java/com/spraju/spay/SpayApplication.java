package com.spraju.spay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spraju.spay.validator.DetailsValidator;

@SpringBootApplication
public class SpayApplication implements CommandLineRunner {
	@Autowired
	DetailsValidator detailsValidator;

	public static void main(String[] args) {
		SpringApplication.run(SpayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(detailsValidator.checkEmailFormat.test("sarathpr1997@gmail.com"));
		
		
	}

}
