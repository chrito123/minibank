package com.sanchezc.minibank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sanchezc.minibank.accountservice.exception.AccountNotFoundException;
import com.sanchezc.minibank.customerservice.exception.CustomerNotFoundException;
import com.sanchezc.minibank.dto.GlobalExceptionDTO;
import com.sanchezc.minibank.transactionservice.exception.TransactionNotFoundException;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public GlobalExceptionDTO handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return new GlobalExceptionDTO("CUSTOMER_NOT_FOUND", ex.getMessage());
    }
    
    @ExceptionHandler(AccountNotFoundException.class)
    public GlobalExceptionDTO handleAccountNotFoundException(AccountNotFoundException ex) {
        return new GlobalExceptionDTO("ACCOUNT_NOT_FOUND", ex.getMessage());
    }
    @ExceptionHandler(TransactionNotFoundException.class)
    public GlobalExceptionDTO handleTransactionNotFoundException(TransactionNotFoundException ex) {
        return new GlobalExceptionDTO("TRANSACTION_NOT_FOUND", ex.getMessage());
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalExceptionDTO handleIllegalArgumentException(IllegalArgumentException ex) {
        return new GlobalExceptionDTO("BAD_REQUEST", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public GlobalExceptionDTO handleGeneralException(Exception ex) {
        return new GlobalExceptionDTO("INTERNAL_SERVER_ERROR", "An unexpected error occurred");
    }
}