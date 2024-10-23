package com.sanchezc.minibank.transactionservice.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.accountservice.repository.AccountRepository;
import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;
import com.sanchezc.minibank.transactionservice.mapper.TransactionMapper;
import com.sanchezc.minibank.transactionservice.model.Transaction;
import com.sanchezc.minibank.transactionservice.repository.TransactionRepository;
import com.sanchezc.minibank.transactionservice.service.TransactionService;

public class TransactionServiceTest {

	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private TransactionMapper transactionMapper;

	@InjectMocks
	private TransactionService transactionService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateTransaction() {
		Account account = new Account(1L, null, 500.0, null);
		when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

		TransactionDTO transactionDTO = new TransactionDTO(1L, 1L, 200.0, LocalDateTime.now());
		Transaction transaction = new Transaction(1L, account, 200.0, null);

		when(transactionMapper.mapToTransaction(transactionDTO)).thenReturn(transaction);
		when(transactionRepository.save(transaction)).thenReturn(transaction);
		when(transactionMapper.mapToTransactionDTO(transaction)).thenReturn(transactionDTO);
		
		TransactionDTO createdTransaction = transactionService.createTransaction(transactionDTO);

		assertThat(createdTransaction.accountId()).isEqualTo(1L);
		assertThat(createdTransaction.amount()).isEqualTo(200.0);
	}


}
