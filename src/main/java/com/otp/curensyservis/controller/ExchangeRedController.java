package com.otp.curensyservis.controller;

import com.otp.curensyservis.dto.ExchangeRequestRedDto;
import com.otp.curensyservis.dto.ExchangeResponseRedDto;
import com.otp.curensyservis.dto.ExchangeUpdateRedDto;
import com.otp.curensyservis.service.impl.ExchangeRedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/exchangeRed")
@RequiredArgsConstructor
@Tag(name = "ExchangeRate", description = "Курсы валют (red)")
public class ExchangeRedController {
    private final ExchangeRedService exchangeRedService;

    @GetMapping("/{id}")
    @Operation(summary = "Получить курс по ID")
    public ExchangeResponseRedDto getById(@PathVariable UUID id) {
        return exchangeRedService.getById(id);
    }

    @PostMapping("/save")
    @Operation(summary = "Сохранить курс")
    public ExchangeResponseRedDto save(@RequestBody ExchangeRequestRedDto exchangeRed) {
        return exchangeRedService.save(exchangeRed);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Обновить курс по ID")
    public ExchangeResponseRedDto update(@RequestBody ExchangeUpdateRedDto exchangeRed, @PathVariable UUID id) {
        return exchangeRedService.update(exchangeRed, id);
    }
}