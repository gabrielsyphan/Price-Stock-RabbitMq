package com.syphan.pricestock.connection;

import com.syphan.constants.RabbitMqConstants;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMqConnection {

    private final AmqpAdmin amqpAdmin;

    @Autowired
    public RabbitMqConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue createQueue(String name) {
        return new Queue(name, true, false, false);
    }

    private DirectExchange getDirectExchange() {
        return new DirectExchange(RabbitMqConstants.EXCHANGE_NAME);
    }

    private Binding createBinding(Queue queue, DirectExchange exchange) {
        String routingKey = queue.getName();
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), routingKey, null);
    }

    @PostConstruct // After bean is created, create queue and binding
    private void setup() {
        // Instantiate queue
        Queue queueStock = this.createQueue(RabbitMqConstants.QUEUE_STOCK);
        Queue queuePrice = this.createQueue(RabbitMqConstants.QUEUE_PRICE);

        // Instantiate direct exchange
        DirectExchange directExchange = this.getDirectExchange();

        // Add queue to exchange
        Binding connectionStock = this.createBinding(queueStock, directExchange);
        Binding connectionPrice = this.createBinding(queuePrice, directExchange);

        // Create queue on RabbitMQ
        this.amqpAdmin.declareQueue(queueStock);
        this.amqpAdmin.declareQueue(queuePrice);

        // Create exchange on RabbitMQ
        this.amqpAdmin.declareExchange(directExchange);

        // Create binding on RabbitMQ
        this.amqpAdmin.declareBinding(connectionStock);
        this.amqpAdmin.declareBinding(connectionPrice);
    }
}
