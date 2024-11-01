package com.sanchezc.minibank.transaction.dto;

import java.time.LocalDateTime;

public record TransactionDTO(
    Long id,
    Long accountId,
    Double amount,
    LocalDateTime transactionDate,
    TransactionTypeDTO type,
    Long destinationAccountId
) {

}