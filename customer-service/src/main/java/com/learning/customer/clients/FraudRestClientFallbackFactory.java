package com.learning.customer.clients;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.learning.customer.exceptions.FraudServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FraudRestClientFallbackFactory implements FallbackFactory<FraudRestClient> {

    @Override
    public FraudRestClient create(Throwable cause) {
        // Log the error
        logger.error("Error occurred in FraudRestClient: {}", cause.getMessage(), cause);

        // Rethrow as a custom exception or handle it with a fallback response
        return new FraudRestClient() {
            @Override
            public JsonNode isFraudster(String customerId) {
                // Optionally provide a fallback response here
                // Throw custom exception after logging
                throw new FraudServiceException("Failed to call FraudRestClient service", cause);
            }
        };
    }
}
