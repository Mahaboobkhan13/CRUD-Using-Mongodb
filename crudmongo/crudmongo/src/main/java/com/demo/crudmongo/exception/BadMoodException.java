package com.demo.crudmongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadMoodException extends RuntimeException {

    public BadMoodException(String message) {
        super(message);
    }
}
