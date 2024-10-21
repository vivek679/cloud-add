package com.learning.fraudservice.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {

    public boolean isFraudulentCustomer(Integer customerId) {
        // Use a 3rd party system | business logic to check if the user is fraud
        FraudCheckHistory fraudCheck = fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return fraudCheck.getIsFraudster();
    }
}
