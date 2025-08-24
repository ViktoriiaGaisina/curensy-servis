package com.otp.curensyservis.service.impl;
import com.otp.curensyservis.dto.ConversionDto;
import com.otp.curensyservis.entity.Conversion;
import java.util.UUID;

public interface ConversionService {
    ConversionDto getById(UUID id);
    ConversionDto save(Conversion conversion);
    ConversionDto update(Conversion conversion);
    void deleteById(UUID id);
    ConversionDto getByCurencyAndRate(Conversion conversionDto);
    ConversionDto convert(ConversionDto conversionDto);
}
