package com.sanchezc.minibank.customerservice.controller.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.sanchezc.minibank.customerservice.controller.CustomerController;
import com.sanchezc.minibank.customerservice.dto.CustomerDTO;
import com.sanchezc.minibank.customerservice.exception.CustomerNotFoundException;
import com.sanchezc.minibank.customerservice.service.CustomerService;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void testGetCustomerDetails_Success() throws Exception {
		Long customerId = 1L;
		CustomerDTO customerDTO = new CustomerDTO(1l, "John", "Doe", null);

		when(customerService.getCustomerById(customerId)).thenReturn(customerDTO);

		mockMvc.perform(get("/api/customers/{customerId}", customerId)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(customerId)).andExpect(jsonPath("$.name").value("John"))
				.andExpect(jsonPath("$.surname").value("Doe"));
	}

	@Test
	public void testGetCustomerDetails_NotFound() throws Exception {
		Long customerId = 500L;

		when(customerService.getCustomerById(customerId)).thenThrow(CustomerNotFoundException.class);
	

		mockMvc.perform(get("/api/customers/{customerId}", customerId)).andExpect(content().string("{\"codeName\":\"CUSTOMER_NOT_FOUND\",\"message\":null}"
				+ ""));
	}
}
