package com.syphan.pricestockconsumer.consumer;

import com.syphan.constants.RabbitMqConstants;
import com.syphan.dto.StockDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StockConsumer {

    @RabbitListener(queues = RabbitMqConstants.QUEUE_STOCK)
    private void stockConsumer(StockDto stockDto) {
        System.out.println("--------------------------------");
        System.out.println("StockConsumer: " + stockDto.toString());
        System.out.println("--------------------------------");
    }
}
