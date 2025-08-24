package com.otp.curensyservis.controller;

import com.otp.curensyservis.dto.ConversionDto;
import com.otp.curensyservis.entity.Conversion;
import com.otp.curensyservis.service.impl.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/conversion")
@RequiredArgsConstructor
public class ConversionController {
    private final ConversionService conversionService;

    @PostMapping("/save")
    public ConversionDto save(Conversion conversion) {
        return conversionService.save(conversion);
    }

    @PutMapping("/update")
    public ConversionDto update(Conversion conversion) {
        return conversionService.update(conversion);
    }

    @GetMapping("/{id}")
    public ConversionDto getById(@PathVariable UUID id) {
        return conversionService.getById(id);
    }

    @GetMapping("/curency-rate")
    public ConversionDto getByCurencyAndRate(Conversion conversion) {
        return conversionService.getByCurencyAndRate(conversion);
    }
}
