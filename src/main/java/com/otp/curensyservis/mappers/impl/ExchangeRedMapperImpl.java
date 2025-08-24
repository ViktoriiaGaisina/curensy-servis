package com.otp.curensyservis.mappers.impl;

import com.otp.curensyservis.dto.ExchangeRedDto;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.entity.ExchangeRed;
import com.otp.curensyservis.mappers.ExchangeRedMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExchangeRedMapperImpl implements ExchangeRedMapper {
    @Override
    public ExchangeRedDto toExchangeRedDto(ExchangeRed exchangeRed) {
        return ExchangeRedDto.builder()
                .rate(exchangeRed.getRate())
                .date(exchangeRed.getDate())
                .curency(Curency.builder()
                        .code(exchangeRed.getCurency().getCode())
                        .name(exchangeRed.getCurency().getName())
                        .build())
                .build();
    }

    @Override
    public ExchangeRed toExchangeRed(ExchangeRedDto exchangeRedDto) {
        return ExchangeRed.builder()
                .rate(exchangeRedDto.getRate())
                .date(exchangeRedDto.getDate())
                .curency(Curency.builder()
                        .code(exchangeRedDto.getCurency().getCode())
                        .name(exchangeRedDto.getCurency().getName())
                        .build())
                .build();
    }

    @Override
    public List<ExchangeRedDto> toExchangeRedDtoList(List<ExchangeRed> exchangeRedList) {
        return exchangeRedList.stream().map(this::toExchangeRedDto).toList();
    }
}
