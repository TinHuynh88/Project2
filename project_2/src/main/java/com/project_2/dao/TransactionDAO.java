package com.project_2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project_2.model.Transaction;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Long>{

	@Query(value="select * from transaction where (transaction_id like :search "
			+ "or concat(transaction_date,'') like :search or transaction_price like :search "
			+")", nativeQuery = true)
	List<Transaction> generalSearchTransaction(@Param("search") String search);
}
