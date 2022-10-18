package com.syphan.pricestock.controller;

import com.syphan.pricestock.dto.PriceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/price")
public class PriceController {

    @PostMapping
    private ResponseEntity<PriceDto> save(PriceDto priceDto) {
        return ResponseEntity.ok(priceDto);
    }
}
