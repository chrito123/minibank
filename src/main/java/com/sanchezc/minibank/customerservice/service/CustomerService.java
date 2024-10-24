package com.sanchezc.minibank.customerservice.service;

import com.sanchezc.minibank.customerservice.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(Long id);

	CustomerDTO createCustomer(CustomerDTO customerDTO);

}