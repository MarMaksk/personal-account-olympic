package com.lk.backend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchParticipantException extends RuntimeException {
    public NoSuchParticipantException() {
        super();
    }

    public NoSuchParticipantException(String message) {
        super(message);
    }
}
