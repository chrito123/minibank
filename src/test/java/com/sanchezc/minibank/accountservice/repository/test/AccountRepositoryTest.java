package com.sanchezc.minibank.accountservice.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.accountservice.repository.AccountRepository;
import com.sanchezc.minibank.customerservice.model.Customer;
import com.sanchezc.minibank.customerservice.repository.CustomerRepository;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAccount() {
        Customer customer = new Customer(null, "Jane", "Doe", null);
        Customer savedCustomer = customerRepository.save(customer);

        Account account = new Account(null, savedCustomer, 1000.0, null);
        Account savedAccount = accountRepository.save(account);

        assertThat(savedAccount.getId()).isNotNull();
        assertThat(savedAccount.getCustomer().getId()).isEqualTo(savedCustomer.getId());
        assertThat(savedAccount.getBalance()).isEqualTo(1000.0);
    }
}