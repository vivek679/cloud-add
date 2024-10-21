package com.learning.userservice.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("Bad request!!");
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
