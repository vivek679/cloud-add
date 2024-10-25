package com.learning.fraudservice.fraud;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    private final FraudCheckMapper fraudCheckMapper;

    public boolean isFraudulentCustomer(String customerId) {
        // Use a 3rd party system | business logic to check if the user is fraud
        return fraudCheckHistoryRepository.save(fraudCheckMapper.toEntity(customerId))
                .getIsFraudster();
    }

    public List<FraudCheckHistoryResponse> getFraudulentCustomerStatus() {
        return fraudCheckHistoryRepository.findAll()
                .stream()
                .map(fraudCheckMapper::toFraudCheckResponse)
                .toList();
    }
}
