package com.sanchezc.minibank.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sanchezc.minibank.accountservice.dto.AccountCreationRequestDTO;
import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/{customerId}/accounts")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "${appName.allowedApi}")
	public AccountDTO createAccount(@PathVariable("customerId") Long customerId,
			@Valid @RequestBody AccountCreationRequestDTO accountCreationRequestDTO) {

		AccountDTO accountDto = new AccountDTO(null, customerId, accountCreationRequestDTO.initialCredit(), null);
		AccountDTO createdAccountDto = accountService.createAccount(accountDto);

		return createdAccountDto;
	}
}
