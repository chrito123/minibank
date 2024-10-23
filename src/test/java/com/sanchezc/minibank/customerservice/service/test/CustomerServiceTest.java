package com.sanchezc.minibank.customerservice.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sanchezc.minibank.customerservice.dto.CustomerDTO;
import com.sanchezc.minibank.customerservice.exception.CustomerNotFoundException;
import com.sanchezc.minibank.customerservice.mapper.CustomerMapper;
import com.sanchezc.minibank.customerservice.model.Customer;
import com.sanchezc.minibank.customerservice.repository.CustomerRepository;
import com.sanchezc.minibank.customerservice.service.CustomerService;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    
    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer(1L, "John", "Doe", null);
        CustomerDTO customerDto = new CustomerDTO(1L, "John", "Doe", null);
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerMapper.mapToCustomerDTO(customer)).thenReturn(customerDto);
        
        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertThat(customerDTO.id()).isEqualTo(1L);
        assertThat(customerDTO.name()).isEqualTo("John");
        assertThat(customerDTO.surname()).isEqualTo("Doe");
    }

    @Test
    public void testGetCustomerById_NotFound() {
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById(1L));
    }
}
