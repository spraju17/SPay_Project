package com.spraju.spay.model;

import com.spraju.spay.entity.CardEntity;

public class Card {
	private Integer cardId;
	private Integer cardNumber;
	private Integer cvv;
	private Integer expiryMonth;
	private Integer expiryYear;
	private Boolean defaultFlag;
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getCvv() {
		return cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	public Integer getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public Integer getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}
	public Boolean getDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(Boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
	
	public static CardEntity preparecardEntity(Card card) {
		CardEntity cardEntity=new CardEntity();
		cardEntity.setCardNumber(card.getCardNumber());
		cardEntity.setCvv(card.getCvv());
		cardEntity.setDefaultFlag(card.getDefaultFlag());
		cardEntity.setExpiryMonth(card.getExpiryMonth());
		cardEntity.setExpiryYear(card.getExpiryYear());
		return cardEntity;	
	}
}
