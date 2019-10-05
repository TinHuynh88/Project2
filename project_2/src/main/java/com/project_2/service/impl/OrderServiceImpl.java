package com.project_2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_2.dao.OrderDAO;
import com.project_2.model.Order;
import com.project_2.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDao;
	
	private List<Order> orders;

	@Override
	public Order createOrder(Order order) {
		return orderDao.save(order);
	}

	@Override
	public void deleteOrder(Order order) {
		orderDao.delete(order);
		
	}

	@Override
	public Order updateOrder(Order order) {
		return orderDao.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public List<Order> getOrdersByTransactionId(long transactionId) {
		orderDao.findAll().forEach( orders -> {
			if ( orders.getTransactionId() == transactionId) {
				this.orders.add(orders);
			}
		});
		return orders;
	}

	@Override
	public List<Order> getOrdersByProductId(long productId) {
		orderDao.findAll().forEach( orders -> {
			if ( orders.getProductId() == productId ) { 
				this.orders.add(orders);
			}
		});
		return orders;
	}

}
