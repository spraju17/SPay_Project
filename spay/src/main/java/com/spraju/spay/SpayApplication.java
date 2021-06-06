package com.spraju.spay;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.spraju.spay.utility.PasswordEncryptDecrypt;
import com.spraju.spay.validator.DetailsValidator;

@SpringBootApplication
@EnableBatchProcessing
@PropertySource(value = {"classpath:message.properties"} )
public class SpayApplication implements CommandLineRunner {
	
	@Autowired
	DetailsValidator detailsValidator;
	
	@Autowired
	PasswordEncryptDecrypt dec;

	public static void main(String[] args) {
		SpringApplication.run(SpayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(PasswordEncryptDecrypt.toHexString(PasswordEncryptDecrypt.getSHA("c06893f37e0735481233d047f8f1ea26f535d0dd7b3ae957ebb51eb64d79aeca")));
	}

}
