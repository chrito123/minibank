package com.sanchezc.minibank.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanchezc.minibank.customer.dto.CustomerDTO;
import com.sanchezc.minibank.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@CrossOrigin(origins = "${appName.allowedApi}")
	@GetMapping("/{customerId}")
	public CustomerDTO getCustomerDetails(@PathVariable("customerId") Long customerId) {
		
		CustomerDTO customerDto = customerService.getCustomerById(customerId);
		return customerDto;
	}
}