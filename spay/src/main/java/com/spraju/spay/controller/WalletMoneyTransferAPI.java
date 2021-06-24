package com.spraju.spay.controller;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.entity.UserEntity;
import com.spraju.spay.utility.ResponseMessage;
import com.spraju.spay.utility.WalletToWalletTransfer;

@RestController
@RequestMapping
public class WalletMoneyTransferAPI {
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	UserDAO userDAO;
		
	@PostMapping("/sendmoney")
	public ResponseEntity<String> sendMoney(@RequestBody WalletToWalletTransfer walletToWalletTransfer) throws Exception{
		var transferAmount=walletToWalletTransfer.getAmmountToTransfer();
		UserEntity sender=userDAO.getById(walletToWalletTransfer.getSender());
		UserEntity receiver=userDAO.getById(walletToWalletTransfer.getReceiver());
		if(sender.getUserWalletEntity().getWalletAmount()<transferAmount) 
			throw new Exception("Insuiffient balance");
			
		rabbitTemplate.convertAndSend("message_queue_exchange","message_routing_key",walletToWalletTransfer);
		
		
		return ResponseEntity.ok("Transfered");
		
	}
}
