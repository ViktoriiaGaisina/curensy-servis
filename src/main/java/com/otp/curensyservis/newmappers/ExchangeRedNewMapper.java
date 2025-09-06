package com.otp.curensyservis.newmappers;


import com.otp.curensyservis.dto.ExchangeRequestRedDto;
import com.otp.curensyservis.dto.ExchangeResponseRedDto;
import com.otp.curensyservis.dto.ExchangeUpdateRedDto;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.entity.ExchangeRed;
import com.otp.curensyservis.repository.CurencyRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ExchangeRedNewMapper {
    @Autowired
    private CurencyRepository curencyRepository;

    public abstract ExchangeResponseRedDto toDto(ExchangeRequestRedDto exchangeRed);

    public abstract ExchangeResponseRedDto toEntity(ExchangeRequestRedDto exchangeRed);

    public abstract ExchangeResponseRedDto toResponseDto(ExchangeRed exchangeRed);

    public abstract ExchangeRed toEntit(ExchangeRequestRedDto exchangeRed);

    @Mapping(target = "curency", source = "exchangeRequestRedDto.curencyCode", qualifiedByName = "toCurencyFromCode")
    public abstract ExchangeRed toEntityFromRequest(ExchangeUpdateRedDto exchangeRequestRedDto, @MappingTarget ExchangeRed exchangeRed);

    @Named("toCurencyFromCode")
    protected Curency toCurencyFromCode(String curencyCode) {
        return curencyRepository.findById(curencyCode).orElseThrow(()
                -> new com.otp.curensyservis.exception.NotFoundException("Curency not found"));
    }
}
