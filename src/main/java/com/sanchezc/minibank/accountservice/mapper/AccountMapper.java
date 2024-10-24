package com.sanchezc.minibank.accountservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;
import com.sanchezc.minibank.accountservice.model.Account;
import com.sanchezc.minibank.customerservice.mapper.CustomerMapper;
import com.sanchezc.minibank.customerservice.repository.CustomerRepository;
import com.sanchezc.minibank.transactionservice.mapper.TransactionMapper;
import com.sanchezc.minibank.transactionservice.repository.TransactionRepository;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class, TransactionMapper.class })
public abstract class AccountMapper {
	@Lazy
	@Autowired
	protected TransactionRepository transactionRepository;

	@Lazy
	@Autowired
	protected CustomerRepository customerRepository;

	@Mapping(target = "customerId", expression = "java(account.getCustomer() != null ? account.getCustomer().getId() : null)")
	@Mapping(target = "transactions", source = "transactions")
	public abstract AccountDTO mapToAccountDto(Account account);

	@Mapping(target = "customer", expression = "java(customerRepository.findById(accountDto.customerId()).get())")
	@Mapping(target = "transactions", expression = "java(transactionRepository.getTransactionsByAccountId(accountDto.id()))")
	public abstract Account mapToAccount(AccountDTO accountDto);

}
