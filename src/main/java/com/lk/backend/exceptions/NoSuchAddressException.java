package com.lk.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchAddressException extends RuntimeException {
    public NoSuchAddressException(String message) {
        super(message);
    }
}