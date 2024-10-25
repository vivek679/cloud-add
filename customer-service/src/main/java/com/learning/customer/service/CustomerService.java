package com.learning.customer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.learning.customer.clients.FraudRestClient;
import com.learning.customer.entity.CustomerEntity;
import com.learning.customer.exceptions.ResourceNotFoundException;
import com.learning.customer.mappers.CustomerMapper;
import com.learning.customer.repository.CustomerRepository;
import com.learning.customer.request.CustomerRequest;
import com.learning.customer.response.CustomerResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final FraudRestClient fraudRestClient;
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Transactional
    public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
        CustomerEntity customerEntity = customerRepository.saveAndFlush(customerMapper.toEntity(customerRequest));
        JsonNode isFraudsterResponse = fraudRestClient.isFraudster(customerEntity.getCustomerId().toString());
        logger.info("Response: {}", isFraudsterResponse);
        return customerMapper.toCustomerResponse(customerEntity);
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponse)
                .toList();
    }

    public CustomerResponse getCustomerById(String customerId) {
        CustomerResponse customerResponse = customerRepository.findById(UUID.fromString(customerId))
                .map(customerMapper::toCustomerResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Customer doesn't exist"));

        // Check if the customer is fraud or not
        var v = fraudRestClient.isFraudster(customerId);
        logger.info("{}", v);
        return customerResponse;
    }
}
