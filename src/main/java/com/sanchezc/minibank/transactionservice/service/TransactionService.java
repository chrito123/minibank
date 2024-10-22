package com.sanchezc.minibank.transactionservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanchezc.minibank.accountservice.exception.AccountNotFoundException;
import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.accountservice.repository.AccountRepository;
import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;
import com.sanchezc.minibank.transactionservice.mapper.TransactionMapper;
import com.sanchezc.minibank.transactionservice.model.Transaction;
import com.sanchezc.minibank.transactionservice.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Optional<Account> accountOptional = accountRepository.findById(transactionDTO.accountId());
        if (accountOptional.isEmpty()) {
            throw new AccountNotFoundException("Account with ID " + transactionDTO.accountId() + " not found");
        }

        Account account = accountOptional.get();
        Transaction transaction = transactionMapper.mapToTransaction(transactionDTO);
        transaction.setAccount(account);
        transaction.setTransactionDate(LocalDateTime.now());
        Transaction savedTransaction = transactionRepository.save(transaction);

        return transactionMapper.mapToTransactionDTO(savedTransaction);
    }

 
}
