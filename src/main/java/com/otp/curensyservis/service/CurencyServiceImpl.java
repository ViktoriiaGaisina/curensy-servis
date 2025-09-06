package com.otp.curensyservis.service;

import com.otp.curensyservis.dto.*;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.feign.PermissionClient;
import com.otp.curensyservis.newmappers.CurencyNewMapper;
import com.otp.curensyservis.repository.CurencyRepository;
import com.otp.curensyservis.service.impl.CurencyService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurencyServiceImpl implements CurencyService {
    private final CurencyRepository curencyRepository;
    private final CurencyNewMapper curencyMapper;
    private final PermissionClient permissionClient;


    @Override
    public CurencyResponseDto getByCode(String code) {
        return curencyRepository.findById(code)
                .map(curencyMapper::toResponseDto)
                .orElseThrow(() -> new com.otp.curensyservis.exception.NotFoundException("Curency not found"));
    }

    @Override
    public void deleteCurencyByCode(String code) {
        Curency curency = curencyRepository.findById(code).orElseThrow(() ->
                new com.otp.curensyservis.exception.NotFoundException("Curency not found"));
        try {
            PermissionDto permissionDto = permissionClient.deletePermission(curency.getCode()).getBody();
            if (permissionDto.getPermission()) {
                curencyRepository.delete(curency);
            } else throw new com.otp.curensyservis.exception.NotFoundException("delete not allowed");
        } catch (FeignException feignException) {
            log.error("FeignException: ", feignException);
            feignException.status();
            throw new com.otp.curensyservis.exception.NotFoundException("service not allowed!!!!!!!!!!!!!!!!!!!!");
        }
    }

    @Override
    public CurencyResponseDto save(CurencyRequestDto curencyRequestDto) {
        Curency curency1 = curencyMapper.toCurency(curencyRequestDto);
        try {
            ResponseEntity<PermissionDto> permissionDto = permissionClient.savePermission(curencyRequestDto.getCode());
            if (permissionDto.getBody().getPermission()) {
                curencyRepository.save(curency1);
            } else throw new com.otp.curensyservis.exception.NotFoundException("permission not allowed");
        } catch (FeignException feignException) {
            log.error("FeignException: ", feignException);
            feignException.status();
        }
        return curencyMapper.toEntities(curency1);
    }

    @Override
    public CurencyResponseDto update(CurencyUpdateDto curencyUpdateDto, String code) {
        Curency curency = curencyRepository.findById(code).orElseThrow(() ->
                new com.otp.curensyservis.exception.NotFoundException("Curency not found"));
        try {
            PermissionDto permissionDto = permissionClient.getPermissionForUpdate(curencyUpdateDto.getCode()).getBody();
            if (permissionDto.getPermission()) {
                curencyMapper.toUpdateEntity(curencyUpdateDto, curency);
            } else throw new com.otp.curensyservis.exception.NotFoundException("update not allowed");
        } catch (FeignException feignException) {
            log.error("FeignException: ", feignException);
            feignException.status();
        }
        return curencyMapper.toResponseDto(curencyRepository.save(curency));
    }

    @Override
    public List<CurencyResponseDto> getAllCurency() {
        return curencyRepository.findAll().stream().map(curencyMapper::toResponseDto).toList();
    }
}
