package com.sanchezc.minibank.accountservice.dto;


public record AccountDTO(
    Long id,
    Long customerId,
    Double balance
) {
}
