package com.sanchezc.minibank.accountservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
	   @Mapping(target = "customerId", source = "customer.id")
	    public AccountDTO mapToAccountDto(Account account);
}
