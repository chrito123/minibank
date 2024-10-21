package com.sanchezc.minibank.customerservice.dto;
import java.util.List;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;

public record CustomerDTO(
    Long id,
    String name,
    String surname,
    List<AccountDTO> accounts
) {
}