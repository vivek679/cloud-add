package com.learning.customer.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.customer.request.CustomerRequest;
import com.learning.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "customer-service/v1/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerRequest customerRequest) {
        logger.info("new customer registration {}", customerRequest);
        return ResponseEntity.ok(customerService.registerCustomer(customerRequest));
    }

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        logger.info("Get all Customers");
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping(path = "/{customerId}")
    public ResponseEntity<?> getCustomers(@PathVariable("customerId") String customerId) {
        logger.info("Get customer detail for: {}", customerId);
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

}
