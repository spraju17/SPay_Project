package com.spraju.spay.service;

import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.entity.UserEntity;
import com.spraju.spay.utility.WalletToWalletTransfer;


@Service
@Transactional
public class WalletToWalletTransferService {
	@Autowired
	UserDAO userDAO;
	
	@RabbitListener(queues = "message_queue")
	public void listener(WalletToWalletTransfer walletToWalletTransfer) throws InterruptedException {
		TimeUnit.SECONDS.sleep(60);
			var transferAmount=walletToWalletTransfer.getAmmountToTransfer();
			UserEntity sender=userDAO.getById(walletToWalletTransfer.getSender());
			UserEntity receiver=userDAO.getById(walletToWalletTransfer.getReceiver());
			if(sender.getUserWalletEntity().getWalletAmount()>=transferAmount) {
				sender.getUserWalletEntity().setWalletAmount(sender.getUserWalletEntity().getWalletAmount()-transferAmount);
				receiver.getUserWalletEntity().setWalletAmount(receiver.getUserWalletEntity().getWalletAmount()+transferAmount);
			
				
			System.out.println("transfred");
			
	}
}
}
