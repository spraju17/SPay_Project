package com.spraju.spay.controller;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spraju.spay.utility.ResponseMessage;
import com.spraju.spay.utility.WalletToWalletTransfer;

@RestController
@RequestMapping
public class WalletMoneyTransferAPI {
	@Autowired
	RabbitTemplate rabbitTemplate;
		
	@PostMapping("/sendmoney")
	public ResponseEntity<String> sendMoney(@RequestBody WalletToWalletTransfer walletToWalletTransfer){
			
		rabbitTemplate.convertAndSend("message_queue_exchange","message_routing_key",walletToWalletTransfer);
		
		
		return ResponseEntity.ok("Transfer initiated");
		
	}
}
