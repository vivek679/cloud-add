package com.learning.customer.exceptions;

public class FraudServiceException extends RuntimeException {
    public FraudServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
