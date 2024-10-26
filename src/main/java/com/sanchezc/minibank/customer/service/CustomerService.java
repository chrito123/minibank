package com.sanchezc.minibank.customer.service;

import com.sanchezc.minibank.customer.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(Long id);

	CustomerDTO createCustomer(CustomerDTO customerDTO);

}