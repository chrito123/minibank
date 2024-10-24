package com.sanchezc.minibank.customerservice.dto.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.customerservice.dto.CustomerDTO;

public class CustomerDTOTest {

    @Test
    public void testCustomerDTO() {
        Long customerId = 1L;
        String name = "John";
        String surname = "Doe";
        List<AccountDTO> accounts = List.of(
            new AccountDTO(1L, customerId, 500.0,null),
            new AccountDTO(2L, customerId, 1000.0,null)
        );

        CustomerDTO customerDTO = new CustomerDTO(customerId, name, surname, accounts);

        assertThat(customerDTO.id()).isEqualTo(customerId);
        assertThat(customerDTO.name()).isEqualTo(name);
        assertThat(customerDTO.surname()).isEqualTo(surname);
        assertThat(customerDTO.accounts()).hasSize(2);
        assertThat(customerDTO.accounts().get(0).balance()).isEqualTo(500.0);
    }
}
