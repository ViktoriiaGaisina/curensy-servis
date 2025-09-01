package com.otp.curensyservis.service.impl;

import com.otp.curensyservis.dto.CurencyRequestDto;
import com.otp.curensyservis.dto.CurencyResponseDto;
import com.otp.curensyservis.dto.CurencyUpdateDto;

import java.util.List;

public interface CurencyService {
    CurencyResponseDto getByCode(String code);
    void deleteCurencyByCode(String code);
    CurencyResponseDto save(CurencyRequestDto curencyRequestDto);
    CurencyResponseDto update(CurencyUpdateDto curency, String code);
    List<CurencyResponseDto> getAllCurency();
}
