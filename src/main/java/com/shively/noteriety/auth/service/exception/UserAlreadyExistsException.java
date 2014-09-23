package com.shively.noteriety.auth.service.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
