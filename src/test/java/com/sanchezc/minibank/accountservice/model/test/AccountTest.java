package com.sanchezc.minibank.accountservice.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.customerservice.model.Customer;

@SpringBootTest
public class AccountTest {
	@Test
	public void testAccountCreation() {
		Long accountId = 1L;
		Long customerId = 1000L;
		Customer customer = new Customer(customerId, "John", "Doe", null);
		Account account = new Account(accountId, customer, 100d,null);
		assertEquals(accountId, account.getId());
		assertEquals(customer, account.getCustomer());
		assertEquals(100, account.getBalance());
	}

	@Test
	public void testAccountEquality() {
		Long accountId = 1L;
		Long customerId = 1000L;
		Customer customer = new Customer(customerId, "John", "Doe", null);
		Account account1 = new Account(accountId, customer, 100d,null);
		Account account2 = new Account(accountId, customer, 100d,null);
		assertEquals(account1, account2);
		assertEquals(account1.hashCode(), account2.hashCode());
	}



}
