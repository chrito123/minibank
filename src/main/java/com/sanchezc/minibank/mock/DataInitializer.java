package com.sanchezc.minibank.mock;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.dto.AccountTypeDTO;
import com.sanchezc.minibank.accountservice.service.AccountService;
import com.sanchezc.minibank.customerservice.dto.CustomerDTO;
import com.sanchezc.minibank.customerservice.service.CustomerService;
import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;
import com.sanchezc.minibank.transactionservice.dto.TransactionTypeDTO;
import com.sanchezc.minibank.transactionservice.service.TransactionService;

@Component
@Profile("dev")
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionService transactionService;

	@Override
	public void run(String... args) throws Exception {

		CustomerDTO[] customers = { new CustomerDTO(null, "Christian", "Sanchez", null),
				new CustomerDTO(null, "Marie", "Dubois", null), new CustomerDTO(null, "Paul", "Martin", null),
				new CustomerDTO(null, "Sophie", "Lemoine", null), new CustomerDTO(null, "Pierre", "Durand", null),
				new CustomerDTO(null, "Julie", "Moreau", null), new CustomerDTO(null, "Jacques", "Rousseau", null),
				new CustomerDTO(null, "Emma", "Blanc", null), new CustomerDTO(null, "Nicolas", "Giraud", null),
				new CustomerDTO(null, "Camille", "Lefevre", null), new CustomerDTO(null, "Thomas", "Bernard", null) };
		for (CustomerDTO customer : customers) {
			customer = customerService.createCustomer(customer);

			AccountDTO savedAccount = accountService
					.createAccount(new AccountDTO(null, customer.id(), 100.5, null, AccountTypeDTO.CURRENT));
			Double amount = (Math.random() * 1000);

			TransactionDTO transactionDTO = new TransactionDTO(null, savedAccount.id(), amount, LocalDateTime.now(),
					TransactionTypeDTO.DEPOSIT, null);
			transactionService.createTransaction(transactionDTO);
			if (Math.random() < 0.6) {
				AccountDTO account2 = new AccountDTO(null, customer.id(), 1500.6, null, AccountTypeDTO.CURRENT);
				accountService.createAccount(account2);
			}

		}

	}

}