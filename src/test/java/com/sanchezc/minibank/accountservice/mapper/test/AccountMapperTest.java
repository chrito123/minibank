package com.sanchezc.minibank.accountservice.mapper.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.mapper.AccountMapper;
import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.customerservice.model.Customer;

@SpringBootTest
public class AccountMapperTest {
	@Autowired
	AccountMapper accountMapper;

	@Test
	public void testAccountMapper() {
		Customer customer = new Customer(1L, "Jane", "Doe", null);
		Account account = new Account(1L, customer, 750.0,null);

		AccountDTO accountDTO = accountMapper.mapToAccountDto(account);

		assertThat(accountDTO.id()).isEqualTo(account.getId());
		assertThat(accountDTO.customerId()).isEqualTo(customer.getId());
		assertThat(accountDTO.balance()).isEqualTo(account.getBalance());
	}
}