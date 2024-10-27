package com.learning.notificationservice.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.learning.notificationservice.request.NotificationRequest;
import com.learning.notificationservice.service.NotificationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQProducer {

//    @Value("${rabbitmq.exchanges.internal}")
//    private String internalExchange;

//    @Value("${rabbitmq.queues.notification}")
//    private String notificationQueue;

//    @Value("${rabbitmq.routing-keys.internal-notification}")
//    private String internalNotificationRoutingKey;

//    private final RabbitTemplate rabbitTemplate;
//    private final NotificationService notificationService;

//    public void send(NotificationRequest message) {
//        logger.info("Message sent -> {}", message);
//        System.out.println("Hello-world");
//        rabbitTemplate.convertAndSend(internalExchange, internalNotificationRoutingKey, message);
//    }

}
