package com.learning.customer.mappers;

import org.springframework.stereotype.Component;

import com.learning.customer.entity.CustomerEntity;
import com.learning.customer.request.CustomerRequest;
import com.learning.customer.response.CustomerResponse;

@Component
public class CustomerMapper {

    public CustomerResponse toCustomerResponse(CustomerEntity customer) {
        return new CustomerResponse(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmailId(),
                customer.getAbout()
        );
    }

    public CustomerResponse toCustomerRatingResponse(CustomerEntity customer) {
        return new CustomerResponse(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmailId(),
                customer.getAbout()
        );
    }

    public CustomerEntity toEntity(CustomerRequest customerRequest) {
        return CustomerEntity.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .emailId(customerRequest.emailId())
                .about(customerRequest.about())
                .build();
    }
}
