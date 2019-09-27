package com.project_2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Products {
	@Id
	@GeneratedValue
	private long product_id;
	private String product_name;
	private double product_price;
	private Date release_date;
	private String category;
	private int quantity;
	private float rating;
	private String system;
	private String picture;

	
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", release_date=" + release_date + ", category=" + category + ", quantity=" + quantity
				+ ", rating=" + rating + ", system=" + system + ", picture=" + picture + "]";
	}


	public Products() {
		// TODO Auto-generated constructor stub
	}


	public Products(long product_id, String product_name, double product_price, Date release_date, String category,
			int quantity, float rating, String system, String picture) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.release_date = release_date;
		this.category = category;
		this.quantity = quantity;
		this.rating = rating;
		this.system = system;
		this.picture = picture;
	}


	public long getProduct_id() {
		return product_id;
	}


	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public double getProduct_price() {
		return product_price;
	}


	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}


	public Date getRelease_date() {
		return release_date;
	}


	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
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


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}
	

}
