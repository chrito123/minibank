package com.sanchezc.minibank.account.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record AccountCreationRequestDTO ( @NotNull @PositiveOrZero Double initialCredit){

}