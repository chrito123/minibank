package com.sanchezc.minibank.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanchezc.minibank.customer.dto.CustomerDTO;
import com.sanchezc.minibank.customer.exception.CustomerNotFoundException;
import com.sanchezc.minibank.customer.mapper.CustomerMapper;
import com.sanchezc.minibank.customer.model.Customer;
import com.sanchezc.minibank.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
	public CustomerDTO getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }

        Customer customer = customerOptional.get();
        return customerMapper.mapToCustomerDTO(customer);
    }
  

    @Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.mapToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.mapToCustomerDTO(savedCustomer);
    }
}
