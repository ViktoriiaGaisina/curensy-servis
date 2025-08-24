package com.otp.curensyservis.mappers.impl;

import com.otp.curensyservis.dto.CurencyDto;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.mappers.CurencyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor

public class CurencyMapperImpl implements CurencyMapper {
    @Override
    public CurencyDto toCurencyDto(Curency curency) {
        return CurencyDto.builder()
                .code(curency.getCode())
                .name(curency.getName())
                .build();
    }

    @Override
    public Curency toCurency(CurencyDto curencyDto) {
        return Curency.builder()
                .code(curencyDto.getCode())
                .name(curencyDto.getName())
                .build();
    }

    @Override
    public List<CurencyDto> toCurencyList(List<Curency> curencyList) {
        return curencyList.stream().map(this::toCurencyDto).toList() ;
    }
}
