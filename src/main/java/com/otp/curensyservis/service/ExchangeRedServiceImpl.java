package com.otp.curensyservis.service;

import com.otp.curensyservis.dto.ExchangeRedDto;
import com.otp.curensyservis.dto.ExchangeRequestRedDto;
import com.otp.curensyservis.dto.ExchangeResponseRedDto;
import com.otp.curensyservis.dto.ExchangeUpdateRedDto;
import com.otp.curensyservis.entity.ExchangeRed;
import com.otp.curensyservis.newmappers.ExchangeRedNewMapper;
import com.otp.curensyservis.repository.ExchangeRedRepository;
import com.otp.curensyservis.service.impl.ExchangeRedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExchangeRedServiceImpl implements ExchangeRedService {
    private final ExchangeRedRepository exchangeRedRepository;
    private final ExchangeRedNewMapper exchangeRedMapper;

    @Override
    public ExchangeResponseRedDto getById(UUID id) {
            ExchangeRed exchangeRed = exchangeRedRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("NOT FOUND"));
            return exchangeRedMapper.toResponseDto(exchangeRed);
    }

    @Override
    public ExchangeResponseRedDto save(ExchangeRequestRedDto exchangeRequestRedDto) {
       ExchangeRed exchangeRed =  exchangeRedMapper.toEntit(exchangeRequestRedDto);
        exchangeRedRepository.save(exchangeRed);
        return exchangeRedMapper.toResponseDto(exchangeRed);
    }

    @Override
    public ExchangeResponseRedDto update(ExchangeUpdateRedDto exchangeRequestRedDto, UUID id) {
        ExchangeRed exchangeRed = exchangeRedRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NOT FOUND"));
        exchangeRedMapper.toEntityFromRequest(exchangeRequestRedDto, exchangeRed);
        return exchangeRedMapper.toResponseDto(exchangeRedRepository.save(exchangeRed));
    }
}
