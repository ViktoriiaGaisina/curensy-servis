package com.otp.curensyservis.mappers;

import com.otp.curensyservis.dto.CurencyDto;
import com.otp.curensyservis.entity.Curency;

import java.util.List;


public interface CurencyMapper {
    CurencyDto toCurencyDto(Curency curency);
    Curency toCurency(CurencyDto curencyDto);
    List<CurencyDto> toCurencyList(List<Curency> curencyDtoList);

}
