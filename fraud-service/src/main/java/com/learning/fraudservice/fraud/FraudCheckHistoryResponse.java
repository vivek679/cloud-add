package com.learning.fraudservice.fraud;

import java.time.LocalDateTime;

public record FraudCheckHistoryResponse(
        Integer fraudId,
        String customerId,
        Boolean isFraudster,
        LocalDateTime createdAt
) {
}
