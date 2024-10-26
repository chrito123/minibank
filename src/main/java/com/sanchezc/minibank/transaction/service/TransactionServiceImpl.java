package com.sanchezc.minibank.transaction.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanchezc.minibank.account.exception.AccountNotFoundException;
import com.sanchezc.minibank.account.model.Account;
import com.sanchezc.minibank.account.repository.AccountRepository;
import com.sanchezc.minibank.transaction.dto.TransactionDTO;
import com.sanchezc.minibank.transaction.mapper.TransactionMapper;
import com.sanchezc.minibank.transaction.model.Transaction;
import com.sanchezc.minibank.transaction.model.TransactionType;
import com.sanchezc.minibank.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionMapper transactionMapper;

	@Override
	public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
		Optional<Account> accountOptional = accountRepository.findById(transactionDTO.accountId());
		if (accountOptional.isEmpty()) {
			throw new AccountNotFoundException("Account with ID " + transactionDTO.accountId() + " not found");
		}

		Account account = accountOptional.get();
		Transaction transaction = transactionMapper.mapToTransaction(transactionDTO);
		transaction.setAccount(account);
		transaction.setTransactionDate(transaction.getTransactionDate());
		transaction.setType(TransactionType.valueOf(transactionDTO.type().toString()));
		Transaction savedTransaction = transactionRepository.save(transaction);

		return transactionMapper.mapToTransactionDTO(savedTransaction);
	}

}
