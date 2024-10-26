package com.sanchezc.minibank.customer.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sanchezc.minibank.customer.dto.CustomerDTO;
import com.sanchezc.minibank.customer.exception.CustomerNotFoundException;
import com.sanchezc.minibank.customer.mapper.CustomerMapper;
import com.sanchezc.minibank.customer.model.Customer;
import com.sanchezc.minibank.customer.repository.CustomerRepository;
import com.sanchezc.minibank.customer.service.CustomerServiceImpl;

public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    
    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

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
    public void testGetCustomerByIdNotFound() {
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById(1L));
    }
}
