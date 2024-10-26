package com.sanchezc.minibank.accountservice.dto;

import java.util.List;

import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;

public record AccountDTO(
    Long id,
    Long customerId,
    Double balance,
    List<TransactionDTO> transactions,
    AccountTypeDTO accountType
) {
}
