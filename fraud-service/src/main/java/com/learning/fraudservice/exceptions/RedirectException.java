package com.learning.fraudservice.exceptions;

public class RedirectException extends RuntimeException {

    public RedirectException() {
        super("Redirection required!!");
    }

    public RedirectException(String message) {
        super(message);
    }

    public RedirectException(String message, Throwable cause) {
        super(message, cause);
    }

}
