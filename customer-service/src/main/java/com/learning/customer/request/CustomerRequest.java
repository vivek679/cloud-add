package com.learning.customer.request;

public record CustomerRequest(
        String firstName,
        String lastName,
        String emailId
) {
}
