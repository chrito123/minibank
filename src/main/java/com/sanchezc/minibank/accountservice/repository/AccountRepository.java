package com.sanchezc.minibank.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanchezc.minibank.accountservice.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
