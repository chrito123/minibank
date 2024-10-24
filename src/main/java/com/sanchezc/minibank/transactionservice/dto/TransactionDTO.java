package com.sanchezc.minibank.transactionservice.dto;

import java.time.LocalDateTime;

public record TransactionDTO(
    Long id,
    Long accountId,
    Double amount,
    LocalDateTime transactionDate
) {

}