package com.otp.curensyservis.service;

import com.otp.curensyservis.dto.CurencyDto;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.mappers.CurencyMapper;
import com.otp.curensyservis.repository.CurencyRepository;
import com.otp.curensyservis.service.impl.CurencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurencyServiceImpl implements CurencyService {
    private final CurencyRepository curencyRepository;
    private final CurencyMapper curencyMapper;


    @Override
    public CurencyDto getByCode(String code) {
        return  curencyRepository.findById(code)
                .map(curencyMapper::toCurencyDto)
                .orElseThrow(() -> new IllegalArgumentException("Curency not found"));
    }

    @Override
    public void deleteCurencyByCode(String code) {
        Curency curency = curencyRepository.findById(code).orElseThrow(() ->
                new IllegalArgumentException("Curency not found"));
        curencyRepository.delete(curency);
    }

    @Override
    public CurencyDto save(Curency curency) {
         curencyRepository.save(curency);
        return curencyMapper.toCurencyDto(curency);
    }

    @Override
    public CurencyDto update(Curency curency) {
        Curency curencies = curencyRepository.findById(curency.getCode()).orElseThrow(() ->
                new IllegalArgumentException("Curency not found"));
        curencies.setName(curency.getName());
         curencyRepository.save(curencies);
         return curencyMapper.toCurencyDto(curencies);
    }

    @Override
    public List<CurencyDto> getAllCurency() {
        List<Curency> curencyList = curencyRepository.findAll();
        return curencyMapper.toCurencyList(curencyList);
    }
}
