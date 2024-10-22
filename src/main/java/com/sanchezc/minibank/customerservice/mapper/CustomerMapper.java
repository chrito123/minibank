package com.sanchezc.minibank.customerservice.mapper;

import org.mapstruct.Mapper;

import com.sanchezc.minibank.customerservice.dto.CustomerDTO;
import com.sanchezc.minibank.customerservice.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	public CustomerDTO mapToCustomerDTO(Customer customer);
	
	public Customer mapToCustomer(CustomerDTO customerDTO);
}
