package com.otp.curensyservis.dto;

import com.otp.curensyservis.entity.Curency;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ConversionDto {
    private UUID id;
    private BigDecimal amount;
    private BigDecimal convertedAmount;
    private BigDecimal rate;
    private Curency fromCurency;
    private Curency toCurency;
}
