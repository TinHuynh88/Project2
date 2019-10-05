package com.project_2.service;

import java.util.List;

import com.project_2.model.Order;
import com.project_2.model.Products;
import com.project_2.model.Transaction;

public interface OrderService {
	
	public Order createOrder(Order order);
	public void deleteOrder(Order order);
	public Order updateOrder(Order order);
	public List<Order> getAllOrders();
	public List<Order> getOrdersByTransactionId(long transactionId);
	public List<Order> getOrdersByProductId(long productId);

}
