package com.sanchezc.minibank.transactionservice.mapper.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.accountservice.model.AccountType;
import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;
import com.sanchezc.minibank.transactionservice.mapper.TransactionMapper;
import com.sanchezc.minibank.transactionservice.model.Transaction;
import com.sanchezc.minibank.transactionservice.model.TransactionType;

@SpringBootTest

public class TransactionMapperTest {
	@Autowired
	TransactionMapper transactionMapper;

	@Test
	public void testTransactionMapper() {
		Account account = new Account(1L, null, 500.0,null,AccountType.CURRENT);
		Transaction transaction = new Transaction(1L, account, 200.0, LocalDateTime.now(),TransactionType.DEPOSIT,null);
		TransactionDTO transactionDTO = transactionMapper.mapToTransactionDTO(transaction);
		assertThat(transactionDTO.id()).isEqualTo(transaction.getId());
		assertThat(transactionDTO.accountId()).isEqualTo(account.getId());
		assertThat(transactionDTO.amount()).isEqualTo(transaction.getAmount());
		assertThat(transactionDTO.transactionDate()).isEqualTo(transaction.getTransactionDate());
	}
}
