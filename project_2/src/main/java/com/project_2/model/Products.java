package com.project_2.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Products implements Serializable{
	@Id
	@GeneratedValue
	private long productId;
	private String productName;
	private double productPrice;
	private Date releaseDate;
	private String category;
	private int quantity;
	private float rating;
	private String system;
	private String[] pictures;

	

	public Products() {
		// TODO Auto-generated constructor stub
	}



	public Products(long productId, String productName, double productPrice, Date releaseDate, String category,
			int quantity, float rating, String system, String[] pictures) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.releaseDate = releaseDate;
		this.category = category;
		this.quantity = quantity;
		this.rating = rating;
		this.system = system;
		this.pictures = pictures;
	}



	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", releaseDate=" + releaseDate + ", category=" + category + ", quantity=" + quantity + ", rating="
				+ rating + ", system=" + system + ", pictures=" + Arrays.toString(pictures) + "]";
	}



	public long getProductId() {
		return productId;
	}



	public void setProductId(long productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public double getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}



	public Date getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public float getRating() {
		return rating;
	}



	public void setRating(float rating) {
		this.rating = rating;
	}



	public String getSystem() {
		return system;
	}



	public void setSystem(String system) {
		this.system = system;
	}



	public String[] getPictures() {
		return pictures;
	}



	public void setPictures(String[] pictures) {
		this.pictures = pictures;
	}

	

}
