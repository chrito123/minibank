package com.sanchezc.minibank.account.dto;

import java.util.List;

import com.sanchezc.minibank.transaction.dto.TransactionDTO;

public record AccountDTO(
    Long id,
    Long customerId,
    Double balance,
    List<TransactionDTO> transactions,
    AccountTypeDTO accountType
) {
}
