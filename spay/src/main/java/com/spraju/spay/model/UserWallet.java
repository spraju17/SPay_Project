package com.spraju.spay.model;

import com.spraju.spay.entity.UserWalletEntity;

public class UserWallet {
	private Integer userWalletId;
	private Float walletAmount;
	private Integer points;
	public Integer getUserWalletId() {
		return userWalletId;
	}
	public void setUserWalletId(Integer userWalletId) {
		this.userWalletId = userWalletId;
	}
	public Float getWalletAmount() {
		return walletAmount;
	}
	public void setWalletAmount(Float walletAmount) {
		this.walletAmount = walletAmount;
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
