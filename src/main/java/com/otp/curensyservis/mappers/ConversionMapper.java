package com.otp.curensyservis.mappers;

import com.otp.curensyservis.dto.ConversionDto;
import com.otp.curensyservis.entity.Conversion;

import java.util.List;

public interface ConversionMapper {
    ConversionDto toConversionDto(Conversion conversion);
    Conversion toConversion(ConversionDto conversionDto);
    List<ConversionDto> toConversionDtoList(List<Conversion> conversionList);
}
