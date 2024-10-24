package com.sanchezc.minibank.mock;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.service.AccountService;
import com.sanchezc.minibank.customerservice.dto.CustomerDTO;
import com.sanchezc.minibank.customerservice.service.CustomerService;
import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;
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
		LocalDateTime start = LocalDateTime.of(2000, 1, 1, 0, 0);
		LocalDateTime end = LocalDateTime.of(2024, 12, 31, 23, 59);

		CustomerDTO[] customers = { new CustomerDTO(null, "Christian", "Sanchez", null),
				new CustomerDTO(null, "Marie", "Dubois", null), new CustomerDTO(null, "Paul", "Martin", null),
				new CustomerDTO(null, "Sophie", "Lemoine", null), new CustomerDTO(null, "Pierre", "Durand", null),
				new CustomerDTO(null, "Julie", "Moreau", null), new CustomerDTO(null, "Jacques", "Rousseau", null),
				new CustomerDTO(null, "Emma", "Blanc", null), new CustomerDTO(null, "Nicolas", "Giraud", null),
				new CustomerDTO(null, "Camille", "Lefevre", null), new CustomerDTO(null, "Thomas", "Bernard", null) };
		for (CustomerDTO customer : customers) {
			customer = customerService.createCustomer(customer);

			AccountDTO savedAccount = accountService.createAccount(new AccountDTO(null, customer.id(), 100.5,null));
			TransactionDTO transactionDTO = new TransactionDTO(null, savedAccount.id(), (Math.random() * 1000),
					generateRandomDateTime(start, end));
			transactionService.createTransaction(transactionDTO);
			if (Math.random() < 0.6) {
				AccountDTO account2 = new AccountDTO(null, customer.id(), 1500.6,null);
				accountService.createAccount(account2);
			}

		}

	}

	public LocalDateTime generateRandomDateTime(LocalDateTime start, LocalDateTime end) {
		long startEpochSecond = start.toEpochSecond(java.time.ZoneOffset.UTC);
		long endEpochSecond = end.toEpochSecond(java.time.ZoneOffset.UTC);

		long randomEpochSecond = ThreadLocalRandom.current().nextLong(startEpochSecond, endEpochSecond);
		return LocalDateTime.ofEpochSecond(randomEpochSecond, 0, java.time.ZoneOffset.UTC);
	}
}