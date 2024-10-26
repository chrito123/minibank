package com.sanchezc.minibank.transaction.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanchezc.minibank.account.model.Account;
import com.sanchezc.minibank.account.model.AccountType;
import com.sanchezc.minibank.customer.model.Customer;
import com.sanchezc.minibank.transaction.model.Transaction;
import com.sanchezc.minibank.transaction.model.TransactionType;

@SpringBootTest
public class TransactionTest {
	@Test
	public void testTransactionCreation() {
		LocalDateTime now = LocalDateTime.now();
		Long transactionId = 1L;
		Long customerId = 1000L;
		Long accountId = 1L;
		Customer customer = new Customer(customerId, "John", "Doe", null);
		Account account1 = new Account(accountId, customer, 100d,null,AccountType.CURRENT);
		Transaction transaction = new Transaction(transactionId, account1, 50d, now,TransactionType.DEPOSIT,null);
		assertEquals(transactionId, transaction.getId());
		assertEquals(account1, transaction.getAccount());
		assertEquals(50, transaction.getAmount());
		assertEquals(now, transaction.getTransactionDate());
	}

	@Test
	public void testTransactionEquality() {
		LocalDateTime now = LocalDateTime.now();
		Long transactionId = 1L;
		Long customerId = 1000L;
		Long accountId = 1L;
		Customer customer = new Customer(customerId, "John", "Doe", null);
		Account account1 = new Account(accountId, customer, 100d,null,AccountType.CURRENT);
		Transaction transaction1 = new Transaction(transactionId, account1, 50d, now,TransactionType.DEPOSIT,null);
		Transaction transaction2 = new Transaction(transactionId, account1, 50d, now,TransactionType.DEPOSIT,null);
		assertEquals(transaction1, transaction2);
		assertEquals(transaction1.hashCode(), transaction2.hashCode());
	}


}
