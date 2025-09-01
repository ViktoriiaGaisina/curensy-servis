package com.otp.curensyservis.service;

import com.otp.curensyservis.dto.CurencyRequestDto;
import com.otp.curensyservis.dto.CurencyResponseDto;
import com.otp.curensyservis.dto.CurencyUpdateDto;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.newmappers.CurencyNewMapper;
import com.otp.curensyservis.repository.CurencyRepository;
import com.otp.curensyservis.service.impl.CurencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurencyServiceImpl implements CurencyService {
    private final CurencyRepository curencyRepository;
    private final CurencyNewMapper curencyMapper;


    @Override
    public CurencyResponseDto getByCode(String code) {
        return curencyRepository.findById(code)
                .map(curencyMapper::toResponseDto)
                .orElseThrow(() -> new IllegalArgumentException("Curency not found"));
    }

    @Override
    public void deleteCurencyByCode(String code) {
        Curency curency = curencyRepository.findById(code).orElseThrow(() ->
                new IllegalArgumentException("Curency not found"));
        curencyRepository.delete(curency);
    }

    @Override
    public CurencyResponseDto save(CurencyRequestDto curencyRequestDto) {
        Curency curency1 = curencyMapper.toCurency(curencyRequestDto);
        curencyRepository.save(curency1);
        return curencyMapper.toEntities(curency1);
    }

    @Override
    public CurencyResponseDto update(CurencyUpdateDto curencyUpdateDto, String code) {
        Curency curency = curencyRepository.findById(code).orElseThrow(() ->
                new IllegalArgumentException("Curency not found"));
        curencyMapper.toUpdateEntity(curencyUpdateDto, curency);
        return curencyMapper.toResponseDto(curencyRepository.save(curency));
    }

    @Override
    public List<CurencyResponseDto> getAllCurency() {
        return curencyRepository.findAll().stream().map(curencyMapper::toResponseDto).toList();
    }
}
