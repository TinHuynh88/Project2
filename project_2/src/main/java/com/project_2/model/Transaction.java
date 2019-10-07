package com.project_2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Transaction implements Serializable{
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
		// EMPTY CONSTRUCTOR BUSINESS STANDARD
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
		long temp;
		temp = Double.doubleToLongBits(transactionPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (Double.doubleToLongBits(transactionPrice) != Double.doubleToLongBits(other.transactionPrice))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}
