package com.otp.curensyservis.service.impl;
import com.otp.curensyservis.dto.ConversionDto;
import com.otp.curensyservis.dto.ConversionRequestDto;
import com.otp.curensyservis.dto.ConversionResponseDto;
import com.otp.curensyservis.dto.ConversionUpdateRequestDto;

import java.util.UUID;

public interface ConversionService {
    ConversionResponseDto getById(UUID id);
    ConversionResponseDto save(ConversionRequestDto conversion);
    ConversionResponseDto update(ConversionUpdateRequestDto conversionUpdateRequestDto, UUID id);
    void deleteById(UUID id);
    //ConversionResponseDto getByCurencyAndRate(ConversionRequestDto conversion);
    ConversionResponseDto convert(ConversionDto conversionDto);
}
