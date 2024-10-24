package com.sanchezc.minibank.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sanchezc.minibank.accountservice.dto.AccountCreationRequestDTO;
import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.service.AccountService;
import com.sanchezc.minibank.customerservice.dto.CustomerDTO;
import com.sanchezc.minibank.customerservice.exception.CustomerNotFoundException;
import com.sanchezc.minibank.customerservice.service.CustomerService;
import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;
import com.sanchezc.minibank.transactionservice.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerAccountController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;

	@PostMapping("/{customerId}/accounts")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountDTO createAccount(@PathVariable("customerId") Long customerId,
		@Valid @RequestBody AccountCreationRequestDTO accountCreationRequestDTO) {

		CustomerDTO customerDTO = customerService.getCustomerById(customerId);

		if (customerDTO == null) {
			throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
		}
		
        AccountDTO accountDto = accountService.getAccountById(customerId);
        
        AccountDTO createdAccountDto = accountService.createAccount(accountDto);
        
        if (accountCreationRequestDTO.initialCredit() > 0) {
        	TransactionDTO transactionDto = new TransactionDTO(null, customerId, accountCreationRequestDTO.initialCredit(), LocalDateTime.now());
            transactionService.createTransaction(transactionDto);
        }
        return  createdAccountDto ;
	}
}
