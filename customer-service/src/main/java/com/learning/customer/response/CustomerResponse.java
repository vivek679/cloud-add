package com.learning.customer.response;

import java.util.UUID;

public record CustomerResponse(
        UUID customerId,
        String firstName,
        String lastName,
        String emailId,
        String about
) {
}
