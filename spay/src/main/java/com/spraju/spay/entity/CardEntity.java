package com.spraju.spay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spraju.spay.model.Card;

@Entity
@Table(name = "CARD")
public class CardEntity {
	@Id
	@Column(name = "CARD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cardId;
	@Column(name = "CARD_NUMBER")
	private Integer cardNumber;
	@Column(name = "CVV")
	private Integer cvv;
	@Column(name = "EXPIRY_MONTH")
	private Integer expiryMonth;
	@Column(name = "EXPIRY_YEAR")
	private Integer expiryYear;
	@Column(name = "DEFAULT_FLAG")
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
	public static Card prepareCard(CardEntity cardEntity) {
		Card card=new Card();
		card.setCardNumber(cardEntity.getCardNumber());
		card.setCvv(cardEntity.getCvv());
		card.setDefaultFlag(cardEntity.getDefaultFlag());
		card.setExpiryMonth(cardEntity.getExpiryMonth());
		card.setExpiryYear(cardEntity.getExpiryYear());
		return card;	
	}
}
