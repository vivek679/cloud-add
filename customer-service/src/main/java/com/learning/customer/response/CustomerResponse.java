package com.learning.customer.response;

public record CustomerResponse(
        Integer customerId,
        String firstName,
        String lastName,
        String emailId
) {
}
