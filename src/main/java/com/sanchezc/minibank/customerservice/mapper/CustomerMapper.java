package com.sanchezc.minibank.customerservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sanchezc.minibank.accountservice.mapper.AccountMapper;
import com.sanchezc.minibank.customerservice.dto.CustomerDTO;
import com.sanchezc.minibank.customerservice.model.Customer;
import com.sanchezc.minibank.transactionservice.mapper.TransactionMapper;

@Mapper(componentModel = "spring", uses =  {AccountMapper.class, TransactionMapper.class})
public interface CustomerMapper {

	@Mapping(target = "accounts", source = "accounts")
	public CustomerDTO mapToCustomerDTO(Customer customer) ;

	public Customer mapToCustomer(CustomerDTO customerDTO);
}
