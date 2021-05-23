package com.spraju.spay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spraju.spay.model.Transaction;
import com.spraju.spay.model.TransactionStatus;

@Entity
@Table(name = "TRANSACTIONS")
public class TransactionEntity {
	@Id
	@Column(name = "TRANSACTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	@Column(name = "SENDER")
	private Integer sender;
	@Column(name = "RECIPIENT")
	private Integer recepient;
	@Column(name = "BILL_ID")
	private Integer billId;
	@Column(name = "AMOUNT")
	private Float amount;
	@Column(name = "POINTS")
	private Integer points;
	@Column(name = "COMMISSION")
	private Float commission;
	@Column(name = "TRANSACTION_STATUS")
	@Enumerated(EnumType.STRING)
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
	
	public static Transaction prepareTransaction(TransactionEntity transactionEntity) {
		Transaction transaction=new Transaction();
		transaction.setAmount(transactionEntity.getAmount());
		transaction.setBillId(transactionEntity.getBillId());
		transaction.setCommission(transactionEntity.getCommission());
		transaction.setPoints(transactionEntity.getPoints());
		transaction.setRecepient(transactionEntity.getRecepient());
		transaction.setSender(transactionEntity.getSender());
		transaction.setTransactionStatus(transactionEntity.getTransactionStatus());
		return transaction;
	}
}
