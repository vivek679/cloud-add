package com.learning.customer.configs;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;
import feign.Retryer;

@Configuration
public class FeignClientConfig {

    @Bean
    public Request.Options requestOptions() {
        // Create an Options instance with custom timeouts and followRedirects set to true
        return new Request.Options(5000, TimeUnit.MILLISECONDS,   // connectTimeout of 5 seconds
                10000, TimeUnit.MILLISECONDS,  // readTimeout of 10 seconds
                true                           // followRedirects enabled
        );
    }

    @Bean
    public Retryer retryer() {
        // Retryer with 3 retry attempts and a period of 100 ms between attempts
        return new Retryer.Default(100, 1000, 3);
    }

}
