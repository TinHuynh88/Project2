<<<<<<< HEAD
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

	@Override
	public String toString() {
		return "ProductPictures [pictureId=" + pictureId + ", pictureURL=" + pictureURL + "]";
	}

	public ProductPictures() {
		// TODO Auto-generated constructor stub
	}

	public ProductPictures(long pictureId, String pictureURL) {
		super();
		this.pictureId = pictureId;
		this.pictureURL = pictureURL;
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

}
=======
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

	@Override
	public String toString() {
		return "ProductPictures [pictureId=" + pictureId + ", pictureURL=" + pictureURL + "]";
	}

	public ProductPictures() {
		// TODO Auto-generated constructor stub
	}

	public ProductPictures(long pictureId, String pictureURL) {
		super();
		this.pictureId = pictureId;
		this.pictureURL = pictureURL;
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

}
>>>>>>> test-master
