package com.sanchezc.minibank.customer.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanchezc.minibank.customer.model.Customer;

@SpringBootTest
public class CustomerTest {
	@Test
	public void testCustomerCreation() {
		Customer customer = new Customer(1L, "John", "Doe", null);
		assertEquals(1L, customer.getId());
		assertEquals("John", customer.getName());
		assertEquals("Doe", customer.getSurname());
	}

	@Test
	public void testCustomerEquality() {
		Customer customer1 = new Customer(1L, "John", "Doe", null);
		Customer customer2 = new Customer(1L, "John", "Doe", null);
		assertEquals(customer1, customer2);
		assertEquals(customer1.hashCode(), customer2.hashCode());
	}

}
