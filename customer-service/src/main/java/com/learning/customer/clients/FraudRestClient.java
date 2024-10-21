package com.learning.customer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.JsonNode;
import com.learning.customer.configs.FeignClientConfig;

@FeignClient(name = "fraud-service", url = "${fraud-service.url}", configuration = FeignClientConfig.class)
public interface FraudRestClient {

    @GetMapping(path = "/fraud-service/api/v1/fraud-check/{customerId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    JsonNode isFraudster(@PathVariable(value = "customerId") Integer customerId);

}