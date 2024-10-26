package com.sanchezc.minibank.account.service;

import com.sanchezc.minibank.account.dto.AccountDTO;

public interface AccountService {

	AccountDTO createAccount(AccountDTO accountDTO);

	AccountDTO getAccountById(Long id);

}