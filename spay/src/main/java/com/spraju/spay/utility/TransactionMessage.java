package com.spraju.spay.utility;

import java.io.Serializable;

public class TransactionMessage implements Serializable {
	private Integer amount;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
