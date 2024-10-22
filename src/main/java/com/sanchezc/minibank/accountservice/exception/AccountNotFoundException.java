package com.sanchezc.minibank.accountservice.exception;

import java.io.Serial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 8347576348941572196L;

	public AccountNotFoundException(String message) {
		super(message);
	}
}