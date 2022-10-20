package com.syphan.pricestock.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String routingKey, Object message) {
        this.rabbitTemplate.convertAndSend(routingKey, message);
    }
}
