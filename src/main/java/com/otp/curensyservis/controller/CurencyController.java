package com.otp.curensyservis.controller;

import com.otp.curensyservis.dto.CurencyRequestDto;
import com.otp.curensyservis.dto.CurencyResponseDto;
import com.otp.curensyservis.dto.CurencyUpdateDto;
import com.otp.curensyservis.service.impl.CurencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/curency")
@RequiredArgsConstructor
@Tag(name = "Currency", description = "Валюты")
public class CurencyController {
    private final CurencyService curencyService;

    @GetMapping("/curencies")
    @Operation(summary = "Список валют")
    public List<CurencyResponseDto> getAllCurency() {
        return curencyService.getAllCurency();
    }

    @GetMapping("/curencies/{code}")
    @Operation(summary = "Получить валюту по коду")
    public CurencyResponseDto getByCode(@PathVariable String code) {
        return curencyService.getByCode(code);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Удалить валюту по коду")
    public void deleteCurencyByCode(@RequestParam String code) {
        curencyService.deleteCurencyByCode(code);
    }

    @PutMapping("/update")
    @Operation(summary = "Обновить валюту по коду")
    public CurencyResponseDto update(@RequestBody CurencyUpdateDto curencyDto, @RequestParam String code) {
        return curencyService.update(curencyDto, code);
    }

    @PostMapping("/save")
    @Operation(summary = "Создать валюту")
    public CurencyResponseDto save(@RequestBody CurencyRequestDto curencyRequestDto) {
        return curencyService.save(curencyRequestDto);
    }
}