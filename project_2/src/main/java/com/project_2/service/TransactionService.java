
package com.project_2.service;

import java.util.List;

import com.project_2.model.Transaction;

public interface TransactionService {


	public Transaction createTransaction(Transaction transaction);
	public List<Transaction> getAllTransactions();
	
}
