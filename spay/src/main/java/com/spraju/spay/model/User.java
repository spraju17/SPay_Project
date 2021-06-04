package com.spraju.spay.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.spraju.spay.entity.CardEntity;
import com.spraju.spay.entity.TransactionEntity;
import com.spraju.spay.entity.UserEntity;

public class User {
	private Integer userId;
	private String emailId;
	private String name;
	private String phoneNumber;
	private String password;
	private UserRole userRole;
	private AccountStatus accountStatus;
	private SecurityQuestion securityQuestion;
	private String securityQuestionAnswer;
	private Address address;
	private TierLevel tierLevel;
	private UserWallet userWallet;
	private List<Card> userCards;
	private List<Transaction> userTransactions;
	public List<Card> getUserCards() {
		return userCards;
	}
	public void setUserCards(List<Card> userCards) {
		this.userCards = userCards;
	}
	public List<Transaction> getUserTransactions() {
		return userTransactions;
	}
	public void setUserTransactions(List<Transaction> userTransactions) {
		this.userTransactions = userTransactions;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	public SecurityQuestion getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(SecurityQuestion securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}
	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public TierLevel getTierLevel() {
		return tierLevel;
	}
	public void setTierLevel(TierLevel tierLevel) {
		this.tierLevel = tierLevel;
	}
	public UserWallet getUserWallet() {
		return userWallet;
	}
	public void setUserWallet(UserWallet userWallet) {
		this.userWallet = userWallet;
	}
	
	public static UserEntity prepareUserEntity(User user) {
		UserEntity userEntity=new UserEntity();
		userEntity.setAccountStatus(user.getAccountStatus());
		//userEntity.setAddressEntity(Address.prepareAddressEntity(user.getAddress()));
		//List<Card> cards=user.getUserCards();
		//List<CardEntity> cardEntities = cards.stream().map(Card::preparecardEntity).collect(Collectors.toCollection(ArrayList::new));
		//userEntity.setCardEntities(cardEntities);
		userEntity.setEmailId(user.getEmailId());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhoneNumber(user.getPhoneNumber());
		userEntity.setSecurityQuestionAnswer(user.getSecurityQuestionAnswer());
		userEntity.setSecurityQuestionEntity(SecurityQuestion.prepareSecurityQuestionEntity(user.getSecurityQuestion()));
		userEntity.setTierLevel(user.getTierLevel());
		//List<TransactionEntity> transactionEntities=user.getUserTransactions().stream().map(Transaction::prepareTransactionEntity).collect(Collectors.toCollection(ArrayList::new));
		//userEntity.setTransactionEntities(transactionEntities);
		userEntity.setUserRole(user.getUserRole());
		userEntity.setUserWalletEntity(UserWallet.prepareUserWalletEntity(user.getUserWallet()));
		return userEntity;
		
	}
	

}
