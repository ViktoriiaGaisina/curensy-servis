package com.otp.curensyservis.mappers.impl;

import com.otp.curensyservis.dto.ConversionDto;
import com.otp.curensyservis.entity.Conversion;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.mappers.ConversionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConversionMapperImpl implements ConversionMapper {
    @Override
    public ConversionDto toConversionDto(Conversion conversion) {
        return ConversionDto.builder()
                .amount(conversion.getAmount())
                .convertedAmount(conversion.getConvertedAmount())
                .rate(conversion.getRate())
                .fromCurency(Curency.builder()
                        .code(conversion.getFromCurency().getCode())
                        .name(conversion.getFromCurency().getName())
                        .build())
                .toCurency(Curency.builder()
                        .code(conversion.getFromCurency().getCode())
                        .name(conversion.getFromCurency().getName())
                        .build())
                .build();
    }

    @Override
    public Conversion toConversion(ConversionDto conversionDto) {
        return Conversion.builder()
                .amount(conversionDto.getAmount())
                .convertedAmount(conversionDto.getConvertedAmount())
                .rate(conversionDto.getRate())
                .fromCurency(Curency.builder()
                        .code(conversionDto.getFromCurency().getCode())
                        .name(conversionDto.getFromCurency().getName())
                        .build())
                .toCurency(Curency.builder()
                        .code(conversionDto.getFromCurency().getCode())
                        .name(conversionDto.getFromCurency().getName())
                        .build())
                .build();
    }

    @Override
    public List<ConversionDto> toConversionDtoList(List<Conversion> conversionList) {
        return conversionList.stream().map(this::toConversionDto).toList();
    }
}
