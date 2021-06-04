package com.spraju.spay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.model.Card;
import com.spraju.spay.service.CardService;
import com.spraju.spay.utility.ResponseMessage;

@RestController
@RequestMapping
public class UserCardAPI {
	
	@Autowired
	CardService cardService;
	
	@PostMapping("/userprofile/card")
	public ResponseEntity<ResponseMessage> addUserCard(@RequestBody Card card) throws Exception{
		
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(201);
		responseMessage.setResponseMessage(cardService.addUserCard(card));
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/userprofile/card")
	public ResponseEntity<List<Card>> getCardDetials(@RequestParam(required = false) Integer cardId) throws Exception{
		List<Card> cards=cardService.getUserCardDetials(cardId);
		return ResponseEntity.ok(cards);
	}
	
	@PutMapping("/userprofile/card/{cardId}")
	public ResponseEntity<ResponseMessage> updateUserCard(@PathVariable Integer cardId,@RequestBody Card card) throws Exception{
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(201);
		responseMessage.setResponseMessage(cardService.updateUserCard(cardId,card));
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.OK);
		return responseEntity;
		
	}
	
	@DeleteMapping("/userprofile/card/{cardId}")
	public ResponseEntity<ResponseMessage> deleteUserCard(@PathVariable Integer cardId){
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(201);
		responseMessage.setResponseMessage(cardService.deleteUserCard(cardId));
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.NO_CONTENT);
		return responseEntity;
		
	}

}
