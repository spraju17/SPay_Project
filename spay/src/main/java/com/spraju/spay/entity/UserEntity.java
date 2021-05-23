package com.spraju.spay.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.spraju.spay.model.AccountStatus;
import com.spraju.spay.model.TierLevel;
import com.spraju.spay.model.UserRole;


@Entity
@Table(name = "REGISTEREDUSER")
public class UserEntity {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "USER_ROLE")
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	@Column(name = "ACCOUNT_STATUS")
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;
	@ManyToOne
	@JoinColumn(name = "SECURITY_QUESTION_ID")
	private SecurityQuestionEntity securityQuestionEntity;
	@Column(name = "SECURITY_ANSWER")
	private String securityQuestionAnswer;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private AddressEntity addressEntity;
	@Column(name = "TIER_LEVEL")
	@Enumerated(EnumType.STRING)
	private TierLevel tierLevel;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "WALLET_ID")
	private UserWalletEntity userWalletEntity;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	java.util.List<CardEntity> cardEntities;
	@OneToMany
	@JoinColumn(name = "USER_ID")
	java.util.List<TransactionEntity> transactionEntities;
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
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
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
	public SecurityQuestionEntity getSecurityQuestionEntity() {
		return securityQuestionEntity;
	}
	public void setSecurityQuestionEntity(SecurityQuestionEntity securityQuestionEntity) {
		this.securityQuestionEntity = securityQuestionEntity;
	}
	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}
	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}
	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}
	public TierLevel getTierLevel() {
		return tierLevel;
	}
	public void setTierLevel(TierLevel tierLevel) {
		this.tierLevel = tierLevel;
	}
	
	public UserWalletEntity getUserWalletEntity() {
		return userWalletEntity;
	}
	public void setUserWalletEntity(UserWalletEntity userWalletEntity) {
		this.userWalletEntity = userWalletEntity;
	}
	public java.util.List<CardEntity> getCardEntities() {
		return cardEntities;
	}
	public void setCardEntities(java.util.List<CardEntity> cardEntities) {
		this.cardEntities = cardEntities;
	}
	public java.util.List<TransactionEntity> getTransactionEntities() {
		return transactionEntities;
	}
	public void setTransactionEntities(java.util.List<TransactionEntity> transactionEntities) {
		this.transactionEntities = transactionEntities;
	}
	
	
	
}
