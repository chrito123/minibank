package com.sanchezc.minibank.accountservice.service;

import com.sanchezc.minibank.accountservice.dto.AccountDTO;

public interface AccountService {

	AccountDTO createAccount(AccountDTO accountDTO);

	AccountDTO getAccountById(Long id);

}