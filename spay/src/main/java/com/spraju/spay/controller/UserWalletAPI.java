package com.spraju.spay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.model.Card;
import com.spraju.spay.model.User;
import com.spraju.spay.model.UserWallet;
import com.spraju.spay.service.UserWalletService;
import com.spraju.spay.utility.CardToWalletTransfer;
import com.spraju.spay.utility.ResponseMessage;

@RestController
@RequestMapping
public class UserWalletAPI {
	
	@Autowired
	UserWalletService userWalletService;
	
	@PostMapping("/moneytransfer")
	public ResponseEntity<ResponseMessage> cardToWalletTransfer(@RequestBody CardToWalletTransfer cardToWalletTransfer) throws Exception{
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(201);
		responseMessage.setResponseMessage(userWalletService.loadUserWalletMoney(cardToWalletTransfer));
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.CREATED);
		return responseEntity;
		
		
	}
	
	@GetMapping("/wallet")
	public ResponseEntity<UserWallet> getUserwallet(){
		 return new ResponseEntity<UserWallet>(userWalletService.getUserwallet(),HttpStatus.OK);
	}

}
