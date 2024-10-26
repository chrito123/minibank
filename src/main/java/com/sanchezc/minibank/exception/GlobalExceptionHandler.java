package com.sanchezc.minibank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.sanchezc.minibank.accountservice.exception.AccountNotFoundException;
import com.sanchezc.minibank.customerservice.exception.CustomerNotFoundException;
import com.sanchezc.minibank.dto.GlobalExceptionDTO;
import com.sanchezc.minibank.transactionservice.exception.TransactionNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GlobalExceptionDTO handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return new GlobalExceptionDTO("CUSTOMER_NOT_FOUND", ex.getMessage());
    }
    
    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GlobalExceptionDTO handleAccountNotFoundException(AccountNotFoundException ex) {
        return new GlobalExceptionDTO("ACCOUNT_NOT_FOUND", ex.getMessage());
    }
    @ExceptionHandler(TransactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GlobalExceptionDTO handleTransactionNotFoundException(TransactionNotFoundException ex) {
        return new GlobalExceptionDTO("TRANSACTION_NOT_FOUND", ex.getMessage());
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalExceptionDTO handleIllegalArgumentException(IllegalArgumentException ex) {
        return new GlobalExceptionDTO("BAD_REQUEST", ex.getMessage());
    }
    
    
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalExceptionDTO handleNoResourceFoundException(NoResourceFoundException ex) {
        return new GlobalExceptionDTO("NO_RESOURCE_FOUND", ex.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public GlobalExceptionDTO handleGeneralException(Exception ex) {
        return new GlobalExceptionDTO("INTERNAL_SERVER_ERROR", "An unexpected error occurred");
    }
}