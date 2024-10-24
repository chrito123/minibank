package com.sanchezc.minibank.transactionservice.service;

import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;

public interface TransactionService {

	TransactionDTO createTransaction(TransactionDTO transactionDTO);

}