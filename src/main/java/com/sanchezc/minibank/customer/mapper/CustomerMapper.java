package com.sanchezc.minibank.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sanchezc.minibank.account.mapper.AccountMapper;
import com.sanchezc.minibank.customer.dto.CustomerDTO;
import com.sanchezc.minibank.customer.model.Customer;
import com.sanchezc.minibank.transaction.mapper.TransactionMapper;

@Mapper(componentModel = "spring", uses =  {AccountMapper.class, TransactionMapper.class})
public interface CustomerMapper {

	@Mapping(target = "accounts", source = "accounts")
	public CustomerDTO mapToCustomerDTO(Customer customer) ;

	public Customer mapToCustomer(CustomerDTO customerDTO);
}
