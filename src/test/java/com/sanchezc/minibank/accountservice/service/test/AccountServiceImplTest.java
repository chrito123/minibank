package com.sanchezc.minibank.accountservice.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.mapper.AccountMapper;
import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.accountservice.model.AccountType;
import com.sanchezc.minibank.accountservice.repository.AccountRepository;
import com.sanchezc.minibank.accountservice.service.AccountServiceImpl;
import com.sanchezc.minibank.customerservice.model.Customer;
import com.sanchezc.minibank.customerservice.repository.CustomerRepository;
import com.sanchezc.minibank.transactionservice.model.Transaction;
import com.sanchezc.minibank.transactionservice.repository.TransactionRepository;

public class AccountServiceImplTest {

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private AccountMapper accountMapper;

	@InjectMocks
	private AccountServiceImpl accountService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateAccount() {
		Customer customer = new Customer(1L, "Jane", "Doe", null);
		when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

		Account account = new Account(1L, customer, 1000.0, null, AccountType.CURRENT);
		Transaction transactionExpected = new Transaction(null, account, 20.0, LocalDateTime.now());
		AccountDTO accountDTO = new AccountDTO(1L, 1L, 1000.0, null, AccountType.CURRENT);
		when(accountMapper.mapToAccount(accountDTO)).thenReturn(account);

		when(accountRepository.save(account)).thenReturn(account);
		when(accountMapper.mapToAccountDto(account)).thenReturn(accountDTO);
		when(transactionRepository.save(transactionExpected)).thenReturn(transactionExpected);

		AccountDTO createdAccount = accountService.createAccount(accountDTO);

		assertThat(createdAccount.customerId()).isEqualTo(1L);
		assertThat(createdAccount.balance()).isEqualTo(1000.0);
	}
}
