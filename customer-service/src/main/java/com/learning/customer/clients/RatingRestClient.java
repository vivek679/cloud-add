package com.learning.customer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.JsonNode;
import com.learning.customer.configs.FeignClientConfig;

@FeignClient(name = "rating-service", configuration = FeignClientConfig.class)
public interface RatingRestClient {

    @GetMapping(path = "/rating-service/v1/ratings/profile/{profileId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    JsonNode getRatingsByProfileId(@PathVariable("profileId") String profileId);


    @GetMapping(path = "/rating-service/v1/ratings/hotels/{hotelId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    JsonNode getRatingsByHotelId(@PathVariable("hotelId") String hotelId);

}