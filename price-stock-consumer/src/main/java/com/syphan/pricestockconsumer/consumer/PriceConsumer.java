package com.syphan.pricestockconsumer.consumer;

import com.syphan.constants.RabbitMqConstants;
import com.syphan.dto.PriceDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PriceConsumer {

    @RabbitListener(queues = RabbitMqConstants.QUEUE_PRICE)
    private void priceConsumer(PriceDto priceDto) {
        System.out.println("--------------------------------");
        System.out.println("PriceConsumer price: " + priceDto.price);
        System.out.println("PriceConsumer codProduct: " + priceDto.codProduct);
        System.out.println("--------------------------------");
    }
}
