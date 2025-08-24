package com.otp.curensyservis.mappers;

import com.otp.curensyservis.dto.ConversionDto;
import com.otp.curensyservis.dto.ExchangeRedDto;
import com.otp.curensyservis.entity.Conversion;
import com.otp.curensyservis.entity.ExchangeRed;

import java.util.List;

public interface ExchangeRedMapper {
    ExchangeRedDto toExchangeRedDto(ExchangeRed exchangeRed);
    ExchangeRed toExchangeRed(ExchangeRedDto exchangeRedDto);
    List<ExchangeRedDto> toExchangeRedDtoList(List<ExchangeRed> exchangeRedList);
}
