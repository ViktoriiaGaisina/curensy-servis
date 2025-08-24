package com.otp.curensyservis.controller;

import com.otp.curensyservis.dto.ExchangeRedDto;
import com.otp.curensyservis.entity.ExchangeRed;
import com.otp.curensyservis.service.impl.ExchangeRedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchangeRed")
@RequiredArgsConstructor
public class ExchangeRedController {
    private final ExchangeRedService exchangeRedService;

    @GetMapping("/getByRate")
    public ExchangeRedDto getByRate(ExchangeRed exchangeRed){
        return exchangeRedService.getByRate(exchangeRed);
    }
    @GetMapping("/getByCurencyAndRate")
    public ExchangeRedDto getByCurencyAndRate(ExchangeRed exchangeRed){
        return exchangeRedService.getByCurencyAndRate(exchangeRed);
    }
    @GetMapping("/save")
    public ExchangeRedDto save(ExchangeRed exchangeRed){
        return exchangeRedService.save(exchangeRed);
    }
    @GetMapping("/update")
    public ExchangeRedDto update(ExchangeRed exchangeRed){
        return exchangeRedService.update(exchangeRed);
    }

}
