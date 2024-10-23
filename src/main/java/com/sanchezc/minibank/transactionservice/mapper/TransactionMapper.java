package com.sanchezc.minibank.transactionservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.sanchezc.minibank.accountservice.repository.AccountRepository;
import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;
import com.sanchezc.minibank.transactionservice.model.Transaction;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper {
	

	@Lazy
	@Autowired
	protected AccountRepository accountRepository;
	
	@Mapping(target = "accountId", source = "account.id")
	public abstract TransactionDTO mapToTransactionDTO(Transaction transaction);
	
	@Mapping(target = "account", expression = "java(accountRepository.findById(transactionDto.accountId()).get())")
	public abstract Transaction mapToTransaction(TransactionDTO transactionDto) ;
		
	
}
