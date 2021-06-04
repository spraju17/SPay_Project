package com.spraju.spay.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.model.Address;
import com.spraju.spay.service.AddressService;
import com.spraju.spay.utility.ResponseMessage;

@RestController
@RequestMapping
public class UserAddressAPI {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/userprofile/address/{addressId}")
	public ResponseEntity<Address> getUserAddress(@PathVariable Integer addressId){
		ResponseEntity<Address> responseEntity=new ResponseEntity<Address>(addressService.getUserAddress(addressId),HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/userprofile/address")
	public ResponseEntity<ResponseMessage> addUserAddress(@RequestBody Address address) throws Exception{
		
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(201);
		responseMessage.setResponseMessage(addressService.addUserAddress(address));
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/userprofile/address/{addressId}")
	public ResponseEntity<ResponseMessage> updateUserAddress(@RequestBody Address address,@PathVariable Integer addressId) throws Exception{
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(201);
		responseMessage.setResponseMessage(addressService.updateUserAddress(address,addressId));
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/userprofile/address/{addressId}")
	public ResponseEntity<ResponseMessage> deleteUserAddress(@PathVariable Integer addressId){
		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setResponseCode(201);
		responseMessage.setResponseMessage(addressService.deleteUserAddress(addressId));
		ResponseEntity<ResponseMessage> responseEntity=new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.CREATED);
		return responseEntity;
	}

}
