package com.sanchezc.minibank.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanchezc.minibank.customerservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
