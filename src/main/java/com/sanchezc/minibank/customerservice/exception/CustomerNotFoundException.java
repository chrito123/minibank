package com.sanchezc.minibank.customerservice.exception;

import java.io.Serial;


public class CustomerNotFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -8482896144531147103L;

	public CustomerNotFoundException(String message) {
        super(message);
    }
}