package com.otp.curensyservis.service;

import com.otp.curensyservis.dto.ConversionDto;
import com.otp.curensyservis.dto.ConversionRequestDto;
import com.otp.curensyservis.dto.ConversionResponseDto;
import com.otp.curensyservis.dto.ConversionUpdateRequestDto;
import com.otp.curensyservis.entity.Conversion;
import com.otp.curensyservis.newmappers.ConversionNewMaper;
import com.otp.curensyservis.repository.ConversionRepository;
import com.otp.curensyservis.service.impl.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ConversionServiceImpl implements ConversionService {
    private final ConversionNewMaper conversionMapper;
    private final ConversionRepository conversionRepository;
    private final ConversionNewMaper conversionNewMaper;

    @Override
    public ConversionResponseDto getById(UUID id) {
        return conversionRepository.findById(id)
                .map(conversionNewMaper::toResponseDto)
                .orElseThrow(() -> new IllegalArgumentException("Conversion not found"));
    }

    @Override
    public ConversionResponseDto save(ConversionRequestDto conversionRequestDto) {
        Conversion conversion = conversionRepository.save(conversionMapper.toEntity(conversionRequestDto));
        return conversionMapper.toResponseDto(conversion);
    }

    @Override
    public ConversionResponseDto update(ConversionUpdateRequestDto conversionUpdateRequestDto, UUID id) {
       Conversion conversion = conversionRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("not found"));
       conversionNewMaper.toEntity(conversionUpdateRequestDto, conversion);
       conversionRepository.save(conversion);
       return conversionMapper.toResponseDto(conversion);

    }

    @Override
    public void deleteById(UUID id) {
        conversionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conversion not found"));
        conversionRepository.deleteById(id);
    }


//    @Override
//    public ConversionResponseDto getByCurencyAndRate(ConversionRequestDto conversion) {
//        return conversionRepository.findByFromCurencyAndToCurencyAndRate(
//                conversion.getFromCurencyCode(), conversion.getToCurencyCode(), conversion.getRate())
//                .map(conversionMapper::toResponseDto)
//                .orElseThrow(() -> new IllegalArgumentException("Conversion not found"));
//    }

    @Override
    public ConversionResponseDto convert(ConversionDto conversionDto) {
        return null;
    }
}
