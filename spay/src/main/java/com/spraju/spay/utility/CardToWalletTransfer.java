package com.spraju.spay.utility;

import com.spraju.spay.model.Card;

public class CardToWalletTransfer {
	private Card card;
	private Double amountToTransfer;
	private Integer OTP;
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Double getAmountToTransfer() {
		return amountToTransfer;
	}
	public void setAmountToTransfer(Double amountToTransfer) {
		this.amountToTransfer = amountToTransfer;
	}
	public Integer getOTP() {
		return OTP;
	}
	public void setOTP(Integer oTP) {
		OTP = oTP;
	}
	

}
