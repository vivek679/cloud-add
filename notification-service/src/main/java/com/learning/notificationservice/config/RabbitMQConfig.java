package com.learning.notificationservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq1.exchanges.internal}")
    private String internalExchange;

//    @Value("${rabbitmq.exchanges.direct.internal}")
//    private String directInternalExchange;

    @Value("${rabbitmq1.queues.notification}")
    private String notificationQueue; //

    @Value("${rabbitmq1.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    @Bean
    public Queue notificationQueue() {
        return new Queue(this.notificationQueue, true);
    }

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

//    @Bean
//    public DirectExchange internalDirectExchange() {
//        return new DirectExchange(this.directInternalExchange);
//    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopicExchange())
                .with(this.internalNotificationRoutingKey);
    }

    @Value("${rabbitmq.exchanges.direct}")
    private String directExchange;

    @Value("${rabbitmq.exchanges.fanout}")
    private String fanoutExchange;

    @Value("${rabbitmq.exchanges.topic}")
    private String topicExchange;

    @Value("${rabbitmq.exchanges.headers}")
    private String headersExchange;

    @Value("${rabbitmq.queues.queue_direct}")
    private String queueDirect;

    @Value("${rabbitmq.queues.queue_fanout}")
    private String queueFanout;

    @Value("${rabbitmq.queues.queue_headers}")
    private String queueHeaders;

    @Value("${rabbitmq.queues.queue_topic}")
    private String queueTopic;

    @Value("${rabbitmq.routing-keys.key1}")
    private String directRoutingKey;

    @Value("${rabbitmq.routing-keys.key2}")
    private String topicRoutingKey;

    //Exchanges
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(directExchange);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(headersExchange);
    }

    @Bean
    public Queue queue1() {
        return new Queue(queueDirect);
    }

    @Bean
    public Queue queue2() {
        return new Queue(queueFanout);
    }

    @Bean
    public Queue queue3() {
        return new Queue(queueTopic);
    }

    @Bean
    public Queue queue4() {
        return new Queue(queueHeaders);
    }

    @Bean
    public Binding directBinding() {
        return BindingBuilder
                .bind(queue1())
                .to(directExchange())
                .with(directRoutingKey);
    }

    @Bean
    public Binding fanoutBinding() {
        return BindingBuilder
                .bind(queue2())
                .to(fanoutExchange());
    }

    @Bean
    public Binding topicBinding() {
        return BindingBuilder
                .bind(queue3())
                .to(topicExchange())
                .with("topic.routing.key");
    }

    @Bean
    public Binding headersBinding() {
        Map<String, Object> headerValues = new HashMap<>();
        headerValues.put("header-key", "header-value");
        return BindingBuilder
                .bind(queue4())
                .to(headersExchange())
                .whereAll(headerValues)
                .match();
    }

}
