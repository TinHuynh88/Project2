package com.project_2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_2.dao.TransactionDAO;
import com.project_2.model.Transaction;
import com.project_2.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired //auto create object
	private TransactionDAO transactionDAO;


	@Override
	public Transaction createTransaction(Transaction transaction) {
		Transaction trans=null;
		try {
		trans=transactionDAO.save(transaction);
		}catch(Exception e){
			trans=null;
		}
		System.out.println("Create Transaction Test: "+trans);
		return trans;
	}


	@Override
	public List<Transaction> getAllTransactions() {
		
		return transactionDAO.findAll();
	}

}
