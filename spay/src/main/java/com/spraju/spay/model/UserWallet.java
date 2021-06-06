package com.spraju.spay.model;

import com.spraju.spay.entity.UserWalletEntity;

public class UserWallet {
	private Integer userWalletId;
	private Double walletAmount;
	private Integer points;
	
	public Integer getUserWalletId() {
		return userWalletId;
	}
	public void setUserWalletId(Integer userWalletId) {
		this.userWalletId = userWalletId;
	}
	public Double getWalletAmount() {
		return walletAmount;
	}
	public void setWalletAmount(Double d) {
		this.walletAmount = d;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public static UserWalletEntity prepareUserWalletEntity(UserWallet userWallet) {
		UserWalletEntity userWalletEntity=new UserWalletEntity();
		userWalletEntity.setPoints(userWallet.getPoints());
		userWalletEntity.setWalletAmount(userWallet.getWalletAmount());
	
		return userWalletEntity;
	}
}
