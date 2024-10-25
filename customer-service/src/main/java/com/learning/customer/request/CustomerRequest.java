package com.learning.customer.request;

import com.fasterxml.jackson.databind.JsonNode;

public record CustomerRequest(
        String firstName,
        String lastName,
        String emailId,
        String about,
        JsonNode ratings
) {
}
