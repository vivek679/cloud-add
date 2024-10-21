package com.learning.customer;

public record CustomerResponse(
        Integer customerId,
        String firstName,
        String lastName,
        String emailId
) {
}
