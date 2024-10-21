package com.learning.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRequest customerRequest) {
        CustomerEntity customer = CustomerEntity.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .emailId(customerRequest.emailId())
                .build();

        // todo: check if email is valid
        // todo: check if email not taken
        // todo: store in customer db
        customerRepository.saveAndFlush(customer);

    }
}
