package com.otp.curensyservis.newmappers;

import com.otp.curensyservis.dto.CurencyDto;
import com.otp.curensyservis.dto.CurencyRequestDto;
import com.otp.curensyservis.dto.CurencyResponseDto;
import com.otp.curensyservis.dto.CurencyUpdateDto;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.repository.CurencyRepository;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;



@Mapper(componentModel = "spring")
public abstract class CurencyNewMapper {
    @Autowired
    private CurencyRepository curencyRepository;

    public abstract  Curency toUpdateEntity (CurencyUpdateDto curency, @MappingTarget Curency curency1);

    public abstract CurencyResponseDto toResponseDto (Curency curency);

    public abstract CurencyDto toCurencyDto(Curency curency);

    public abstract Curency toCurency(CurencyRequestDto curencyDto);

    public abstract CurencyResponseDto toEntities (Curency curency);

}
