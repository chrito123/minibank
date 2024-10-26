package com.sanchezc.minibank.account.controller.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanchezc.minibank.account.controller.AccountController;
import com.sanchezc.minibank.account.dto.AccountCreationRequestDTO;
import com.sanchezc.minibank.account.dto.AccountDTO;
import com.sanchezc.minibank.account.dto.AccountTypeDTO;
import com.sanchezc.minibank.account.service.AccountService;
import com.sanchezc.minibank.customer.dto.CustomerDTO;
import com.sanchezc.minibank.customer.service.CustomerService;
import com.sanchezc.minibank.transaction.dto.TransactionDTO;
import com.sanchezc.minibank.transaction.dto.TransactionTypeDTO;
import com.sanchezc.minibank.transaction.service.TransactionService;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@MockBean
	private AccountService accountService;

	@MockBean
	private TransactionService transactionService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testCreateAccountWithInitialCredit() throws Exception {
		Double initialCredit = 1000.0;
		Long customerId = 1L;

		CustomerDTO customerDTO = new CustomerDTO(customerId, "John", "Doe", null);
		AccountDTO accountDTO = new AccountDTO(1L, customerId, initialCredit, null, AccountTypeDTO.CURRENT);

		when(customerService.getCustomerById(customerId)).thenReturn(customerDTO);
		when(accountService.getAccountById(customerId)).thenReturn(accountDTO);
		when(accountService.createAccount(accountDTO)).thenReturn(accountDTO);

		TransactionDTO transactionDto = new TransactionDTO(null, customerId, accountDTO.balance(), LocalDateTime.now(),TransactionTypeDTO.DEPOSIT,null);
		when(transactionService.createTransaction(transactionDto)).thenReturn(transactionDto);
		AccountCreationRequestDTO accountCreationRequestDTO = new AccountCreationRequestDTO(initialCredit);
		mockMvc.perform(post("/api/customers/{customerId}/accounts", customerId).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(accountCreationRequestDTO))).andExpect(status().isCreated());
	}

	@Test
	public void testCreateAccountWithoutInitialCredit() throws Exception {
		Double initialCredit = 0.0;
		Long customerId = 1L;

		CustomerDTO customerDTO = new CustomerDTO(customerId, "John", "Doe", null);
		AccountDTO accountDTO = new AccountDTO(1L, customerId, initialCredit, null, AccountTypeDTO.CURRENT);

		when(customerService.getCustomerById(customerId)).thenReturn(customerDTO);
		when(accountService.getAccountById(customerId)).thenReturn(accountDTO);
		when(accountService.createAccount(accountDTO)).thenReturn(accountDTO);

		TransactionDTO transactionDto = new TransactionDTO(null, customerId, accountDTO.balance(), LocalDateTime.now(),TransactionTypeDTO.DEPOSIT,null);
		when(transactionService.createTransaction(transactionDto)).thenReturn(transactionDto);
		AccountCreationRequestDTO accountCreationRequestDTO = new AccountCreationRequestDTO(initialCredit);
		mockMvc.perform(post("/api/customers/{customerId}/accounts", customerId).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(accountCreationRequestDTO))).andExpect(status().isCreated());
	}
}
