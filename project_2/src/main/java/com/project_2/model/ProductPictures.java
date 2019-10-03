package com.project_2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

@Entity
@Table
@Indexed
public class ProductPictures {
	
	
	@Id
	@GeneratedValue
	private long pictureId;
	private String pictureURL;
	
	@JoinColumn(name="productId")
	private long productId;
	
	@Override
	public String toString() {
		return "ProductPictures [pictureId=" + pictureId + ", pictureURL=" + pictureURL + ", productId=" + productId
				+ "]";
	}
	
	public ProductPictures() {
		// TODO Auto-generated constructor stub
	}

	public ProductPictures(long pictureId, String pictureURL, long productId) {
		super();
		this.pictureId = pictureId;
		this.pictureURL = pictureURL;
		this.productId = productId;
	}

	public long getPictureId() {
		return pictureId;
	}

	public void setPictureId(long pictureId) {
		this.pictureId = pictureId;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

}
