package com.project_2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

import javax.persistence.FetchType;

@Entity
@Table(name = "order_table")
//@Indexed
public class Order implements Serializable{
	
	@Id
	@GeneratedValue
	private long orderId;
	
	@ManyToOne
	private Transaction transaction;
	
	@ManyToOne
	private Products product;
	 
	private int quantitySold;
	
	private double totalUnitPrice;
	
	

	public Order() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", transaction=" + transaction + ", product=" + product
				+ ", quantitySold=" + quantitySold + ", totalUnitPrice=" + totalUnitPrice + "]";
	}



	public Order(long orderId, Transaction transaction, Products product, int quantitySold, double totalUnitPrice) {
		super();
		this.orderId = orderId;
		this.transaction = transaction;
		this.product = product;
		this.quantitySold = quantitySold;
		this.totalUnitPrice = totalUnitPrice;
	}



	public long getOrderId() {
		return orderId;
	}



	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}



	public Transaction getTransaction() {
		return transaction;
	}



	public void setTransaction(Transaction transaction) {
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
