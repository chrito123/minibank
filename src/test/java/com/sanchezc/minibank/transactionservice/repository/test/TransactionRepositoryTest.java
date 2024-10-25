package com.sanchezc.minibank.transactionservice.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.accountservice.model.AccountType;
import com.sanchezc.minibank.accountservice.repository.AccountRepository;
import com.sanchezc.minibank.customerservice.model.Customer;
import com.sanchezc.minibank.customerservice.repository.CustomerRepository;
import com.sanchezc.minibank.transactionservice.model.Transaction;
import com.sanchezc.minibank.transactionservice.repository.TransactionRepository;


@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveTransaction() {
        Customer customer = new Customer(null, "John", "Smith", null);
        Customer savedCustomer = customerRepository.save(customer);

        Account account = new Account(null, savedCustomer, 500.0,null,AccountType.CURRENT);
        Account savedAccount = accountRepository.save(account);

        Transaction transaction = new Transaction(null, savedAccount, 200.0, LocalDateTime.now());
        Transaction savedTransaction = transactionRepository.save(transaction);

        assertThat(savedTransaction.getId()).isNotNull();
        assertThat(savedTransaction.getAccount().getId()).isEqualTo(savedAccount.getId());
        assertThat(savedTransaction.getAmount()).isEqualTo(200.0);
    }
}
