package com.sanchezc.minibank.accountservice.dto.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.dto.AccountTypeDTO;

public class AccountDTOTest {

    @Test
    public void testAccountDTO() {
        Long accountId = 1L;
        Long customerId = 1L;
        Double balance = 500.0;

        AccountDTO accountDTO = new AccountDTO(accountId, customerId, balance,null,AccountTypeDTO.CURRENT);

        assertThat(accountDTO.id()).isEqualTo(accountId);
        assertThat(accountDTO.customerId()).isEqualTo(customerId);
        assertThat(accountDTO.balance()).isEqualTo(balance);
    }
}