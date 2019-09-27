package com.project_2.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Orders {
	
	private long transaction_id;
	private long product_id;
	private int quantity_sold;
	private double total_unit_price;
}
