package com.spraju.spay.utility;

import java.util.List;

public class CurrentlyLoggedUserIdDetails {
	private Integer currentlyLoggedUserAddressId;
	private Integer currentlyLoggedUserWalletId;
	private Integer currentlyLoggedUserSecurityQuestionId;
	private List<Integer> currentlyLoggedUserCardId;
	private List<Integer> currentlyLoggedUserTransactionId;
	
	private Integer currentlyLoggedUserId;
	public Integer getCurrentlyLoggedUserId() {
		return currentlyLoggedUserId;
	}
	public void setCurrentlyLoggedUserId(Integer currentlyLoggedUserId) {
		this.currentlyLoggedUserId = currentlyLoggedUserId;
	}
	public Integer getCurrentlyLoggedUserAddressId() {
		return currentlyLoggedUserAddressId;
	}
	public void setCurrentlyLoggedUserAddressId(Integer currentlyLoggedUserAddressId) {
		this.currentlyLoggedUserAddressId = currentlyLoggedUserAddressId;
	}
	public Integer getCurrentlyLoggedUserWalletId() {
		return currentlyLoggedUserWalletId;
	}
	public void setCurrentlyLoggedUserWalletId(Integer currentlyLoggedUserWalletId) {
		this.currentlyLoggedUserWalletId = currentlyLoggedUserWalletId;
	}
	public Integer getCurrentlyLoggedUserSecurityQuestionId() {
		return currentlyLoggedUserSecurityQuestionId;
	}
	public void setCurrentlyLoggedUserSecurityQuestionId(Integer currentlyLoggedUserSecurityQuestionId) {
		this.currentlyLoggedUserSecurityQuestionId = currentlyLoggedUserSecurityQuestionId;
	}
	public List<Integer> getCurrentlyLoggedUserCardId() {
		return currentlyLoggedUserCardId;
	}
	public void setCurrentlyLoggedUserCardId(List<Integer> currentlyLoggedUserCardId) {
		this.currentlyLoggedUserCardId = currentlyLoggedUserCardId;
	}
	public List<Integer> getCurrentlyLoggedUserTransactionId() {
		return currentlyLoggedUserTransactionId;
	}
	public void setCurrentlyLoggedUserTransactionId(List<Integer> currentlyLoggedUserTransactionId) {
		this.currentlyLoggedUserTransactionId = currentlyLoggedUserTransactionId;
	}
	
}
