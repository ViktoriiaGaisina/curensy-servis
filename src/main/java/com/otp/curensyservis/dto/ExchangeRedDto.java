package com.otp.curensyservis.dto;

import com.otp.curensyservis.entity.Curency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ExchangeRedDto {
    private UUID id;
    private BigDecimal rate;
    private LocalDateTime date;
    private Curency curency;
}
