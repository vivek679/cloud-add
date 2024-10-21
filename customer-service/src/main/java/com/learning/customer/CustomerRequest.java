package com.learning.customer;

public record CustomerRequest(
        String firstName,
        String lastName,
        String emailId
) {
}
