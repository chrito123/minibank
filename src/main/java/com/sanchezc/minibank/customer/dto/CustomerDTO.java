package com.sanchezc.minibank.customer.dto;
import java.util.List;

import com.sanchezc.minibank.account.dto.AccountDTO;

public record CustomerDTO(
    Long id,
    String name,
    String surname,
    List<AccountDTO> accounts
) {
}