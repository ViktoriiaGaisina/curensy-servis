package com.otp.curensyservis.repository;

import com.otp.curensyservis.dto.ExchangeRedDto;
import com.otp.curensyservis.entity.ExchangeRed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.UUID;

public interface ExchangeRedRepository extends JpaRepository<ExchangeRed, UUID> {
    ExchangeRedDto findByRate(BigDecimal rate);
}
