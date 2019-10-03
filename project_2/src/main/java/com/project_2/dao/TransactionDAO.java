package com.project_2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_2.model.Transaction;

public interface TransactionDAO extends JpaRepository<Transaction, Long>{

}
