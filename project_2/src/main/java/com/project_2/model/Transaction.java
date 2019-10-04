package com.project_2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {
	@Id
	@GeneratedValue
	private long transactionId;
	private Date transactionDate;
	private double transactionPrice;
	@ManyToOne
	private User user;
	
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionPrice=" + transactionPrice + ", user=" + user + "]";
	}
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(long transactionId, Date transactionDate, double transactionPrice, User user) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionPrice = transactionPrice;
		this.user = user;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionPrice() {
		return transactionPrice;
	}

	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
