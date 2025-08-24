package com.otp.curensyservis.service;

import com.otp.curensyservis.dto.ConversionDto;
import com.otp.curensyservis.entity.Conversion;
import com.otp.curensyservis.mappers.ConversionMapper;
import com.otp.curensyservis.repository.ConversionRepository;
import com.otp.curensyservis.service.impl.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ConversionServiceImpl implements ConversionService {
    private final ConversionMapper conversionMapper;
    private final ConversionRepository conversionRepository;

    @Override
    public ConversionDto getById(UUID id) {
        return conversionRepository.findById(id)
                .map(conversionMapper::toConversionDto)
                .orElseThrow(() -> new IllegalArgumentException("Conversion not found"));
    }

    @Override
    public ConversionDto save(Conversion conversion) {
        conversionRepository.save(conversion);
        return conversionMapper.toConversionDto(conversion);
    }

    @Override
    public ConversionDto update(Conversion conversion) {
       Conversion conversion1 = conversionRepository.findById(conversion.getId())
               .orElseThrow(() -> new IllegalArgumentException("not found"));
       conversion1.setRate(conversion.getRate());
       conversion1.setAmount(conversion.getAmount());
       conversionRepository.save(conversion1);
       return conversionMapper.toConversionDto(conversion1);

    }

    @Override
    public void deleteById(UUID id) {
        conversionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conversion not found"));
        conversionRepository.deleteById(id);
    }

    @Override
    public ConversionDto getByCurencyAndRate(Conversion conversion) {
        return conversionRepository.findByFromCurencyAndToCurencyAndRate(
                conversion.getFromCurency(), conversion.getToCurency(), conversion.getRate())
                .map(conversionMapper::toConversionDto)
                .orElseThrow(() -> new IllegalArgumentException("Conversion not found"));
    }

    @Override
    public ConversionDto convert(ConversionDto conversionDto) {
        return null;
    }
}
