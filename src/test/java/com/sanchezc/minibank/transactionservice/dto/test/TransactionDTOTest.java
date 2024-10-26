package com.sanchezc.minibank.transactionservice.dto.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;
import com.sanchezc.minibank.transactionservice.dto.TransactionTypeDTO;

public class TransactionDTOTest {

    @Test
    public void testTransactionDTO() {
        Long transactionId = 1L;
        Long accountId = 1L;
        Double amount = 200.0;
        LocalDateTime transactionDate = LocalDateTime.now();

        TransactionDTO transactionDTO = new TransactionDTO(transactionId, accountId, amount, transactionDate,TransactionTypeDTO.DEPOSIT,null);

        assertThat(transactionDTO.id()).isEqualTo(transactionId);
        assertThat(transactionDTO.accountId()).isEqualTo(accountId);
        assertThat(transactionDTO.amount()).isEqualTo(amount);
        assertThat(transactionDTO.transactionDate()).isEqualTo(transactionDate);
    }
}
