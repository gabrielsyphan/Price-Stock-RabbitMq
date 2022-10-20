package com.syphan.pricestock.controller;

import com.syphan.constants.RabbitMqConstants;
import com.syphan.dto.StockDto;
import com.syphan.pricestock.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    private final RabbitMqService rabbitMqService;

    @Autowired
    public StockController(RabbitMqService rabbitMqService) {
        this.rabbitMqService = rabbitMqService;
    }

    @PostMapping
    private ResponseEntity<StockDto> save(@RequestBody StockDto stockDto) {
        System.out.println("StockController.save: " + stockDto.toString());
        this.rabbitMqService.sendMessage(RabbitMqConstants.QUEUE_STOCK, stockDto);
        return ResponseEntity.ok(stockDto);
    }
}
