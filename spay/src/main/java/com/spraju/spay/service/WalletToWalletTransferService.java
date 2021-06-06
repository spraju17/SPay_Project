package com.spraju.spay.service;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.spraju.spay.utility.WalletToWalletTransfer;


@Service
public class WalletToWalletTransferService {
	
	@RabbitListener(queues = "message_queue")
	public void listener(WalletToWalletTransfer walletToWalletTransfer) {
		try {
			TimeUnit.MINUTES.sleep(1);
			System.out.println("transfred");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
