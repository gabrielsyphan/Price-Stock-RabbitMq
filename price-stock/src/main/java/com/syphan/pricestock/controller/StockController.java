package com.syphan.pricestock.controller;

import com.syphan.pricestock.dto.StockDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @PostMapping
    private ResponseEntity<StockDto> save(@RequestBody StockDto stockDto) {
        return ResponseEntity.ok(stockDto);
    }
}
