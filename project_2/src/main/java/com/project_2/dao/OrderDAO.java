package com.project_2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project_2.model.Order;
import com.project_2.model.Products;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

}
