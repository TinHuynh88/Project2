package com.project_2.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

//@Entity
@Table
@Indexed
public class Order {
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transactionId")
	private Transaction transaction;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productId")
	private Products products;
	 
	private int quantitySold;
	
	private double totalUnitPrice;
	
	
	@Override
	public String toString() {
		return "Orders [transaction=" + transaction + ", products=" + products + ", quantitySold=" + quantitySold
				+ ", totalUnitPrice=" + totalUnitPrice + "]";
	}


	public Order() {
		// TODO Auto-generated constructor stub
	}


	public Order(Transaction transaction, Products products, int quantitySold, double totalUnitPrice) {
		super();
		this.transaction = transaction;
		this.products = products;
		this.quantitySold = quantitySold;
		this.totalUnitPrice = totalUnitPrice;
	}


	public Transaction getTransaction() {
		return transaction;
	}


	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}


	public Products getProduct() {
		return products;
	}


	public void setProduct(Products products) {
		this.products = products;
	}


	public int getQuantitySold() {
		return quantitySold;
	}


	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}


	public double getTotalUnitPrice() {
		return totalUnitPrice;
	}


	public void setTotalUnitPrice(double totalUnitPrice) {
		this.totalUnitPrice = totalUnitPrice;
	}
	
	
	
	
	
}
