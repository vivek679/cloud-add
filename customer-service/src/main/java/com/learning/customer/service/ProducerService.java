package com.learning.customer.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchanges.direct}")
    private String directExchange;

    @Value("${rabbitmq.exchanges.fanout}")
    private String fanoutExchange;

    @Value("${rabbitmq.exchanges.topic}")
    private String topicExchange;

    @Value("${rabbitmq.exchanges.headers}")
    private String headersExchange;

    @Value("${rabbitmq.routing-keys.key1}")
    private String directRoutingKey;

    @Value("${rabbitmq.routing-keys.key2}")
    private String topicRoutingKey;

    public void sendToDirectExchange(String message) {
        rabbitTemplate.convertAndSend(directExchange, directRoutingKey, message);
    }

    public void sendToFanoutExchange(String message) {
        rabbitTemplate.convertAndSend(fanoutExchange, "", message);
    }

    public void sendToTopicExchange(String message) {
        rabbitTemplate.convertAndSend(topicExchange, topicRoutingKey, message);
    }

    public void sendToHeadersExchange(String message) {
        MessageProperties properties = new MessageProperties();
        properties.setHeader("header-key", "header-value");
        Message msg = new Message(message.getBytes(), properties);
        rabbitTemplate.send(headersExchange, "", msg);
    }

}
