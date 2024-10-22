package com.sanchezc.minibank.transactionservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sanchezc.minibank.transactionservice.dto.TransactionDTO;
import com.sanchezc.minibank.transactionservice.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
	
	@Mapping(target = "accountId", source = "account.id")
	public TransactionDTO mapToTransactionDTO(Transaction transaction);
}
