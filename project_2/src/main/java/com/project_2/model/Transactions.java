package com.project_2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Transactions {
	@Id
	@GeneratedValue
	private long transaction_id;
	private Date transaction_date;
	private double transaction_price;
	private String username;
}
