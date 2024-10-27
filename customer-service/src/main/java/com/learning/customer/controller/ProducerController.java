package com.learning.customer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.customer.service.ProducerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rabbitmq-producer/v1/producer")
public class ProducerController {

    private final ProducerService producerService;

    // Send to Direct Exchange
    @PostMapping("/sendDirect")
    public ResponseEntity<String> sendDirectMessage(@RequestBody String message) {
        producerService.sendToDirectExchange(message);
        return ResponseEntity.ok("Message sent to Direct Exchange");
    }

    // Send to Fanout Exchange
    @PostMapping("/sendFanout")
    public ResponseEntity<String> sendFanoutMessage(@RequestBody String message) {
        producerService.sendToFanoutExchange(message);
        return ResponseEntity.ok("Message sent to Fanout Exchange");
    }

    // Send to Topic Exchange
    @PostMapping("/sendTopic")
    public ResponseEntity<String> sendTopicMessage(@RequestBody String message) {
        producerService.sendToTopicExchange(message);
        return ResponseEntity.ok("Message sent to Topic Exchange");
    }

    // Send to Headers Exchange
    @PostMapping("/sendHeaders")
    public ResponseEntity<String> sendHeadersMessage(@RequestBody String message) {
        producerService.sendToHeadersExchange(message);
        return ResponseEntity.ok("Message sent to Headers Exchange");
    }
}
