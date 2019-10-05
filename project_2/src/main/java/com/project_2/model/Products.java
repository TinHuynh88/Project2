package com.project_2.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Products {
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
		// EMPTY CONSTRUCTOR BUSINESS STANDARD
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", releaseDate=" + releaseDate + ", category=" + category + ", quantity=" + quantity + ", rating="
				+ rating + ", system=" + system + ", pictures=" + Arrays.toString(pictures) + "]";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + Arrays.hashCode(pictures);
		result = prime * result + (int) (productId ^ (productId >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + Float.floatToIntBits(rating);
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((system == null) ? 0 : system.hashCode());
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
		Products other = (Products) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (!Arrays.equals(pictures, other.pictures))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		if (quantity != other.quantity)
			return false;
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (system == null) {
			if (other.system != null)
				return false;
		} else if (!system.equals(other.system))
			return false;
		return true;
	}
		
}
