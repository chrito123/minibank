package com.sanchezc.minibank.customerservice.exception;

import java.io.Serial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -8482896144531147103L;

	public CustomerNotFoundException(String message) {
        super(message);
    }
}