package com.project_2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

@Entity
@Table
@Indexed
public class Order {

	@Id
	@GeneratedValue
	private long orderId;
	
	
	@ManyToOne
	@JoinColumn(name="transactionId")
	private long transactionId;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private long productId;
	 
	private int quantitySold;
	
	private double totalUnitPrice;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", transactionId=" + transactionId + ", productId=" + productId
				+ ", quantitySold=" + quantitySold + ", totalUnitPrice=" + totalUnitPrice + "]";
	}

	public Order(long orderId, long transactionId, long productId, int quantitySold, double totalUnitPrice) {
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantitySold = quantitySold;
		this.totalUnitPrice = totalUnitPrice;
	}

	

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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
