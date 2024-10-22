package com.sanchezc.minibank.transactionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanchezc.minibank.transactionservice.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	public List<Transaction> getTransactionsByAccountId (Long id);
}
