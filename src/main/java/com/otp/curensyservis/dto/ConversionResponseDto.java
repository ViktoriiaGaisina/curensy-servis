package com.otp.curensyservis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@Schema(name = "ConversionResponseDto", description = "Ответ на операцию конвертации")
public class ConversionResponseDto {
        @Schema(description = "Исходная сумма", example = "100.00")
        private BigDecimal amount;
        @Schema(description = "Сконвертированная сумма", example = "9200.00")
        private BigDecimal convertedAmount;
        @Schema(description = "Курс конвертации", example = "92.00")
        private BigDecimal rate;
        @Schema(description = "Целевая валюта")
        private CurencyDto toCurency;
        @Schema(description = "Исходная валюта")
        private CurencyDto fromCurency;

    }
