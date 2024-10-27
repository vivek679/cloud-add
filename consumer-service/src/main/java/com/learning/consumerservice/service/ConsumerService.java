package com.learning.consumerservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @RabbitListener(queues = "${rabbitmq.queues.queue_direct}")
    public void listenQueue1(String message) {
        System.out.println("Received from queue_direct: " + message);
    }

    @RabbitListener(queues = "${rabbitmq.queues.queue_fanout}")
    public void listenQueue2(String message) {
        System.out.println("Received from queue_fanout: " + message);
    }

    @RabbitListener(queues = "${rabbitmq.queues.queue_topic}")
    public void listenQueue3(String message) {
        System.out.println("Received from queue_topic: " + message);
    }

    @RabbitListener(queues = "${rabbitmq.queues.queue_headers}")
    public void listenQueue4(String message) {
        System.out.println("Received from queue_headers: " + message);
    }
}
