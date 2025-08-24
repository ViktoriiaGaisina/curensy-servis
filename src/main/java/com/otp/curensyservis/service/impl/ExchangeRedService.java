package com.otp.curensyservis.service.impl;
import com.otp.curensyservis.dto.ExchangeRedDto;
import com.otp.curensyservis.entity.ExchangeRed;


public interface ExchangeRedService {
    ExchangeRedDto getByRate(ExchangeRed exchangeRed);
    ExchangeRedDto getByCurencyAndRate(ExchangeRed exchangeRed);
    ExchangeRedDto save(ExchangeRed exchangeRed);
    ExchangeRedDto update(ExchangeRed exchangeRed);
}
