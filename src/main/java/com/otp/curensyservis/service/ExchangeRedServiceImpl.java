package com.otp.curensyservis.service;

import com.otp.curensyservis.dto.ExchangeRedDto;
import com.otp.curensyservis.entity.ExchangeRed;
import com.otp.curensyservis.mappers.ExchangeRedMapper;
import com.otp.curensyservis.repository.ExchangeRedRepository;
import com.otp.curensyservis.service.impl.ExchangeRedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeRedServiceImpl implements ExchangeRedService {
    private final ExchangeRedRepository exchangeRedRepository;
    private final ExchangeRedMapper exchangeRedMapper;

    @Override
    public ExchangeRedDto getByRate(ExchangeRed exchangeRed) {
        exchangeRedRepository.findByRate(exchangeRed.getRate());
        if(exchangeRedRepository.findByRate(exchangeRed.getRate()) == null){
            return null;
        }
        return exchangeRedMapper.toExchangeRedDto(exchangeRed);
    }

    @Override
    public ExchangeRedDto getByCurencyAndRate(ExchangeRed exchangeRed) {
        return null;
    }

    @Override
    public ExchangeRedDto save(ExchangeRed exchangeRed) {
        exchangeRedRepository.save(exchangeRed);
        return exchangeRedMapper.toExchangeRedDto(exchangeRed);
    }

    @Override
    public ExchangeRedDto update(ExchangeRed exchangeRed) {
        exchangeRedRepository.findById(exchangeRed.getId()).orElseThrow(() -> new IllegalArgumentException("not found"));
        exchangeRed.setRate(exchangeRed.getRate());
        exchangeRed.setDate(exchangeRed.getDate());
        exchangeRedRepository.save(exchangeRed);
        return exchangeRedMapper.toExchangeRedDto(exchangeRed);
    }
}
