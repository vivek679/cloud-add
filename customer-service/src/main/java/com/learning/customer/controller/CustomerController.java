package com.learning.customer.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.customer.clients.FraudRestClient;
import com.learning.customer.request.CustomerRequest;
import com.learning.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "customer-service/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final FraudRestClient fraudRestClient;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerRequest customerRequest) {
        logger.info("new customer registration {}", customerRequest);
        customerService.registerCustomer(customerRequest, fraudRestClient);
        return ResponseEntity.ok().build();
    }
}
