package com.syphan.pricestock.controller;

import com.syphan.constants.RabbitMqConstants;
import com.syphan.dto.PriceDto;
import com.syphan.pricestock.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/price")
public class PriceController {

    private final RabbitMqService rabbitMqService;

    @Autowired
    public PriceController(RabbitMqService rabbitMqService) {
        this.rabbitMqService = rabbitMqService;
    }

    @PostMapping
    private ResponseEntity<PriceDto> save(@RequestBody PriceDto priceDto) {
        System.out.println("PriceController.save: " + priceDto.toString());
        this.rabbitMqService.sendMessage(RabbitMqConstants.QUEUE_PRICE, priceDto);
        return ResponseEntity.ok(priceDto);
    }
}
