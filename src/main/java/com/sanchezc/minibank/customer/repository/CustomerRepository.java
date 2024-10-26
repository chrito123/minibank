package com.sanchezc.minibank.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanchezc.minibank.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
