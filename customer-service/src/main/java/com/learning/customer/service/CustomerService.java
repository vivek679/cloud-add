package com.learning.customer.service;

import org.springframework.stereotype.Service;

import com.learning.customer.clients.FraudRestClient;
import com.learning.customer.entity.CustomerEntity;
import com.learning.customer.repository.CustomerRepository;
import com.learning.customer.request.CustomerRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRequest customerRequest, FraudRestClient fraudRestClient) {
        CustomerEntity customer = CustomerEntity.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .emailId(customerRequest.emailId())
                .build();

        // todo: check if email is valid
        // todo: check if email not taken
        // todo: store in customer db
        customerRepository.saveAndFlush(customer);
        var v = fraudRestClient.isFraudster(customer.getCustomerId());
        logger.info("Response: {}", v);
        v.get("isFraudster");

    }
}
