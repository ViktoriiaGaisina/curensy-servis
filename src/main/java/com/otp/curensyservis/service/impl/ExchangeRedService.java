package com.otp.curensyservis.service.impl;

import com.otp.curensyservis.dto.ExchangeRequestRedDto;
import com.otp.curensyservis.dto.ExchangeResponseRedDto;
import com.otp.curensyservis.dto.ExchangeUpdateRedDto;

import java.util.UUID;

public interface ExchangeRedService {
    ExchangeResponseRedDto getById(UUID id);

    ExchangeResponseRedDto save(ExchangeRequestRedDto exchangeRed);

    ExchangeResponseRedDto update(ExchangeUpdateRedDto exchangeRed, UUID id);
}
