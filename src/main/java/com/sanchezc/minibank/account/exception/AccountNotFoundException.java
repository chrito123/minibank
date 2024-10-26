package com.sanchezc.minibank.account.exception;

import java.io.Serial;

public class AccountNotFoundException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 8347576348941572196L;

	public AccountNotFoundException(String message) {
		super(message);
	}
}