package com.learning.fraudservice.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class FraudCheckMapper {

    public FraudCheckHistoryResponse toFraudCheckResponse(FraudCheckHistoryEntity fraudCheckHistory) {
        return new FraudCheckHistoryResponse(
                fraudCheckHistory.getFraudId(),
                fraudCheckHistory.getCustomerId(),
                fraudCheckHistory.getIsFraudster(),
                fraudCheckHistory.getCreatedAt());
    }

    public FraudCheckHistoryEntity toEntity(String customerId) {
        return FraudCheckHistoryEntity.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();

    }
}
