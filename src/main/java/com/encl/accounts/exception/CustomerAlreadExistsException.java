package com.encl.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadExistsException extends RuntimeException{

    public CustomerAlreadExistsException(String message) {
        super(message);
    }
}
