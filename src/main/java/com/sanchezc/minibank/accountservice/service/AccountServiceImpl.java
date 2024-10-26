package com.sanchezc.minibank.accountservice.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.mapper.AccountMapper;
import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.accountservice.model.AccountType;
import com.sanchezc.minibank.accountservice.repository.AccountRepository;
import com.sanchezc.minibank.customerservice.exception.CustomerNotFoundException;
import com.sanchezc.minibank.customerservice.model.Customer;
import com.sanchezc.minibank.customerservice.repository.CustomerRepository;
import com.sanchezc.minibank.transactionservice.model.Transaction;
import com.sanchezc.minibank.transactionservice.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountMapper accountMapper;
	
	@Transactional
	@Override
	public synchronized AccountDTO createAccount(AccountDTO accountDTO) {
		Optional<Customer> customerOptional = customerRepository.findById(accountDTO.customerId());
		if (customerOptional.isEmpty()) {
			throw new CustomerNotFoundException("Customer with ID " + accountDTO.customerId() + " not found");
		}
		double initialCredit = accountDTO.balance();
		Customer customer = customerOptional.get();
		Account account = accountMapper.mapToAccount(accountDTO);
		account.setCustomer(customer);
		account.setType(AccountType.CURRENT);
		Account savedAccount = accountRepository.save(account);
		if (initialCredit > 0) {
			Transaction transaction = new Transaction();
			transaction.setAmount(initialCredit);
			transaction.setAccount(account);
			transaction.setTransactionDate(LocalDateTime.now());
			transactionRepository.save(transaction);
		}
		return accountMapper.mapToAccountDto(savedAccount);

	}

	@Override
	public AccountDTO getAccountById(Long id) {
		Optional<Account> accountOptional = accountRepository.findById(id);
		if (accountOptional.isEmpty()) {
			throw new CustomerNotFoundException("Account with ID " + id + " not found");
		}
		Account account = accountOptional.get();
		return accountMapper.mapToAccountDto(account);
	}

}