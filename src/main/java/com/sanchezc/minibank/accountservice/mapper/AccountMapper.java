package com.sanchezc.minibank.accountservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.customerservice.repository.CustomerRepository;
import com.sanchezc.minibank.transactionservice.repository.TransactionRepository;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {
	@Lazy
	@Autowired
	protected TransactionRepository transactionRepository;

	@Lazy
	@Autowired
	protected CustomerRepository customerRepository;

	@Mapping(target = "customerId", source = "customer.id")
	public abstract AccountDTO mapToAccountDto(Account account);

	@Mapping(target = "customer", expression = "java(customerRepository.findById(accountDto.customerId()).get())")
	@Mapping(target = "transactions", expression = "java(transactionRepository.getTransactionsByAccountId(accountDto.id()))")
	public abstract Account mapToAccount(AccountDTO accountDto) ;

}
