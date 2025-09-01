package com.otp.curensyservis.controller;

import com.otp.curensyservis.dto.ConversionRequestDto;
import com.otp.curensyservis.dto.ConversionResponseDto;
import com.otp.curensyservis.dto.ConversionUpdateRequestDto;
import com.otp.curensyservis.service.impl.ConversionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/conversion")
@Tag(name = "Conversions", description = "Операции конвертации валют")
@RequiredArgsConstructor
public class ConversionController {
    private final ConversionService conversionService;

    @PostMapping("/save")
    @Operation(summary = "Создать конвертацию")
    public ConversionResponseDto save(ConversionRequestDto conversion) {
        return conversionService.save(conversion);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить конвертацию по ID")
    public ConversionResponseDto update(ConversionUpdateRequestDto conversion, @PathVariable UUID id) {
        return conversionService.update(conversion, id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить конвертацию по ID")
    public ConversionResponseDto getById(@PathVariable UUID id) {
        return conversionService.getById(id);
    }

    @GetMapping("/curency-rate")
    public ConversionResponseDto getByCurencyAndRate(ConversionRequestDto conversionRequestDto) {
        return null;
    }
}
