package com.project_2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Orders {
	@Id
	@ManyToOne
	private Transactions transaction;
	@Id
	@ManyToOne
	private Products product;
	private int quantitySold;
	private double totalUnitPrice;
	
	
	@Override
	public String toString() {
		return "Orders [transaction=" + transaction + ", product=" + product + ", quantitySold=" + quantitySold
				+ ", totalUnitPrice=" + totalUnitPrice + "]";
	}


	public Orders() {
		// TODO Auto-generated constructor stub
	}


	public Orders(Transactions transaction, Products product, int quantitySold, double totalUnitPrice) {
		super();
		this.transaction = transaction;
		this.product = product;
		this.quantitySold = quantitySold;
		this.totalUnitPrice = totalUnitPrice;
	}


	public Transactions getTransaction() {
		return transaction;
	}


	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}


	public Products getProduct() {
		return product;
	}


	public void setProduct(Products product) {
		this.product = product;
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
