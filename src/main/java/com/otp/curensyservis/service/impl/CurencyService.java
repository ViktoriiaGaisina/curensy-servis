package com.otp.curensyservis.service.impl;

import com.otp.curensyservis.dto.CurencyDto;
import com.otp.curensyservis.entity.Curency;

import java.util.List;

public interface CurencyService {
    CurencyDto getByCode(String code);
    void deleteCurencyByCode(String code);
    CurencyDto save(Curency curency);
    CurencyDto update(Curency curency);
    List<CurencyDto> getAllCurency();

}
