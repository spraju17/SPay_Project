package com.spraju.spay.model;

import com.spraju.spay.entity.TransactionEntity;

public class Transaction {
	private Integer transactionId;
	private Integer sender;
	private Integer recepient;
	private Integer billId;
	private Float amount;
	private Integer points;
	private Float commission;
	private TransactionStatus transactionStatus;
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getSender() {
		return sender;
	}
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	public Integer getRecepient() {
		return recepient;
	}
	public void setRecepient(Integer recepient) {
		this.recepient = recepient;
	}
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Float getCommission() {
		return commission;
	}
	public void setCommission(Float commission) {
		this.commission = commission;
	}
	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	public static TransactionEntity prepareTransactionEntity(Transaction transaction) {
		TransactionEntity transactionEntity=new TransactionEntity();
		transactionEntity.setAmount(transaction.getAmount());
		transactionEntity.setBillId(transaction.getBillId());
		transactionEntity.setCommission(transaction.getCommission());
		transactionEntity.setPoints(transaction.getPoints());
		transactionEntity.setRecepient(transaction.getRecepient());
		transactionEntity.setSender(transaction.getSender());
		transactionEntity.setTransactionStatus(transaction.getTransactionStatus());
		return transactionEntity;
	}
	
}
