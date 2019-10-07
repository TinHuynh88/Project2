package com.project_2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_2.dao.OrderDAO;
import com.project_2.model.Order;
import com.project_2.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

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
    	System.out.println("TTTT = "+transactionId);
    	List<Order> orderList = new ArrayList<Order>();
        orderDao.findAll().forEach( order -> {
        	System.out.println(order.getTransaction().getTransactionId());
        	
            if ( order.getTransaction().getTransactionId() == transactionId) {
            	orderList.add(order);
            }
        });
        return orderList;
    }
    @Override
    public List<Order> getOrdersByProductId(long productId) {
        orderDao.findAll().forEach( orders -> {
            if ( orders.getProduct().getProductId() == productId ) {
                this.orders.add(orders);
            }
        });
        return orders;
    }

}
