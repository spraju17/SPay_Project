package com.spraju.spay.utility;

import java.io.Serializable;

public class WalletToWalletTransfer implements Serializable {
	private Integer sender;
	private Integer receiver;
	private Integer ammountToTransfer;
	
	public Integer getSender() {
		return sender;
	}
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	public Integer getReceiver() {
		return receiver;
	}
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}
	public Integer getAmmountToTransfer() {
		return ammountToTransfer;
	}
	public void setAmmountToTransfer(Integer ammountToTransfer) {
		this.ammountToTransfer = ammountToTransfer;
	}
	
}
