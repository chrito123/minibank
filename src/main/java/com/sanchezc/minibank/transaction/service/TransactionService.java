package com.sanchezc.minibank.transaction.service;

import com.sanchezc.minibank.transaction.dto.TransactionDTO;

public interface TransactionService {

	TransactionDTO createTransaction(TransactionDTO transactionDTO);

}