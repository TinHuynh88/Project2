package com.project_2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project_2.model.Transaction;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Long>{

}
