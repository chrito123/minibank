package com.sanchezc.minibank.transaction.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.sanchezc.minibank.account.mapper.AccountMapper;
import com.sanchezc.minibank.account.repository.AccountRepository;
import com.sanchezc.minibank.customer.mapper.CustomerMapper;
import com.sanchezc.minibank.transaction.dto.TransactionDTO;
import com.sanchezc.minibank.transaction.model.Transaction;

@Mapper(componentModel = "spring", uses = { AccountMapper.class, CustomerMapper.class })
public abstract class TransactionMapper {

	@Lazy
	@Autowired
	protected AccountRepository accountRepository;

	@Mapping(target = "destinationAccountId", ignore = true)
	@Mapping(target = "accountId", expression = "java(transaction.getAccount().getId())")
	public abstract TransactionDTO mapToTransactionDTO(Transaction transaction);

	@Mapping(target = "destinationAccount", ignore = true)
	@Mapping(target = "account", expression = "java(accountRepository.findById(transactionDto.accountId()).get())")
	public abstract Transaction mapToTransaction(TransactionDTO transactionDto);

}
