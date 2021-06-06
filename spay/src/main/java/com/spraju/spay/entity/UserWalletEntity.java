package com.spraju.spay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spraju.spay.model.UserWallet;

@Entity
@Table(name = "USER_WALLET")
public class UserWalletEntity {
	@Id
	@Column(name = "WALLET_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userWalletId;
	@Column(name = "WALLET_AMOUNT")
	private Double walletAmount;
	@Column(name = "POINTS")
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
	public void setWalletAmount(Double walletAmount) {
		this.walletAmount = walletAmount;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public static UserWallet prepareUserWallet(UserWalletEntity userWalletEntity) {
		UserWallet userWallet=new UserWallet();
		userWallet.setPoints(userWalletEntity.getPoints());
		userWallet.setUserWalletId(userWalletEntity.getUserWalletId());
		userWallet.setWalletAmount(userWalletEntity.getWalletAmount());
		return userWallet;
	}
	
}
