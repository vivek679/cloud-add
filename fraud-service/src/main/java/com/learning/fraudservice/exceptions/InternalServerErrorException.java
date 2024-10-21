package com.learning.fraudservice.exceptions;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException() {
        super("Internal server error!!");
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}