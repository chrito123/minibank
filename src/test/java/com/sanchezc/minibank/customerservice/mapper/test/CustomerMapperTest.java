package com.sanchezc.minibank.customerservice.mapper.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.dto.AccountTypeDTO;
import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.accountservice.model.AccountType;
import com.sanchezc.minibank.customerservice.dto.CustomerDTO;
import com.sanchezc.minibank.customerservice.mapper.CustomerMapper;
import com.sanchezc.minibank.customerservice.model.Customer;

@SpringBootTest
public class CustomerMapperTest {
	@Autowired
	CustomerMapper customerMapper;

	@Test
	public void testCustomerMapper() {
		Account account1 = new Account(1L, null, 500.0, null, AccountType.CURRENT);
		Account account2 = new Account(2L, null, 1000.0, null, AccountType.CURRENT);
		Customer customer = new Customer(1L, "John", "Doe", List.of(account1, account2));

		CustomerDTO customerDTO = customerMapper.mapToCustomerDTO(customer);

		assertThat(customerDTO.id()).isEqualTo(customer.getId());
		assertThat(customerDTO.name()).isEqualTo(customer.getName());
		assertThat(customerDTO.surname()).isEqualTo(customer.getSurname());
		assertThat(customerDTO.accounts()).hasSize(2);
		assertThat(customerDTO.accounts().get(0).id()).isEqualTo(account1.getId());
		assertThat(customerDTO.accounts().get(0).balance()).isEqualTo(account1.getBalance());
		assertThat(customerDTO.accounts().get(1).id()).isEqualTo(account2.getId());
		assertThat(customerDTO.accounts().get(1).balance()).isEqualTo(account2.getBalance());
	}

	@Test
	public void testCustomerDTOToCustomerMapping() {
		AccountDTO accountDTO1 = new AccountDTO(1L, 1L, 500.0, null, AccountTypeDTO.CURRENT);
		AccountDTO accountDTO2 = new AccountDTO(2L, 1L, 1000.0, null, AccountTypeDTO.CURRENT);
		CustomerDTO customerDTO = new CustomerDTO(1L, "John", "Doe", List.of(accountDTO1, accountDTO2));

		Customer customer = customerMapper.mapToCustomer(customerDTO);

		assertThat(customer.getId()).isEqualTo(customerDTO.id());
		assertThat(customer.getName()).isEqualTo(customerDTO.name());
		assertThat(customer.getSurname()).isEqualTo(customerDTO.surname());
		assertThat(customer.getAccounts()).hasSize(2);
		assertThat(customer.getAccounts().get(0).getId()).isEqualTo(accountDTO1.id());
		assertThat(customer.getAccounts().get(0).getBalance()).isEqualTo(accountDTO1.balance());
		assertThat(customer.getAccounts().get(1).getId()).isEqualTo(accountDTO2.id());
		assertThat(customer.getAccounts().get(1).getBalance()).isEqualTo(accountDTO2.balance());
	}
}
