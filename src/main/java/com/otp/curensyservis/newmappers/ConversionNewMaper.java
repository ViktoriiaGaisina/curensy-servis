package com.otp.curensyservis.newmappers;

import com.otp.curensyservis.dto.ConversionRequestDto;
import com.otp.curensyservis.dto.ConversionResponseDto;
import com.otp.curensyservis.dto.ConversionUpdateRequestDto;
import com.otp.curensyservis.entity.Conversion;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.repository.CurencyRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CurencyNewMapper.class})
public abstract class ConversionNewMaper {
    @Autowired
    private CurencyRepository curencyRepository;

    @Mapping(target = "fromCurency", source = "fromCurencyCode", qualifiedByName = "curencyCodeToCurency")
    @Mapping(target = "toCurency", source = "toCurencyCode", qualifiedByName = "curencyCodeToCurency")
    public abstract Conversion toEntity(ConversionRequestDto request);

    public abstract ConversionResponseDto toResponseDto(Conversion entity);

    public abstract List<ConversionResponseDto> toResponseDtoList(List<Conversion> entities);

    @Named( "curencyCodeToCurency")
    protected Curency curencyCodeToCurency(String curencyCode) {
        return curencyRepository.findById(curencyCode).orElseThrow(() ->
                new IllegalArgumentException("Curency not found"));
    }

    @Mapping(target = "fromCurency", source = "fromCurencyCode", qualifiedByName = "curencyCodeToCurency")
    @Mapping(target = "toCurency", source = "toCurencyCode", qualifiedByName = "curencyCodeToCurency")
    public abstract Conversion toEntity(ConversionUpdateRequestDto updateRequestDto, @MappingTarget Conversion conversion);
}
