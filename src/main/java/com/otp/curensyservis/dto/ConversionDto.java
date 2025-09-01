package com.otp.curensyservis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@Schema(name = "ConversionDto", description = "Представление конвертации")
public class ConversionDto {
    @Schema(description = "ID конвертации", example = "9f1b3e1a-1234-4bcd-8ef0-1234567890ab")
    private UUID id;
    @Schema(description = "Исходная сумма", example = "100.00")
    private BigDecimal amount;
    @Schema(description = "Сконвертированная сумма", example = "9200.00")
    private BigDecimal convertedAmount;
    @Schema(description = "Курс конвертации", example = "92.00")
    private BigDecimal rate;
    @Schema(description = "Код исходной валюты", example = "USD")
    private String fromCurency;
    @Schema(description = "Код целевой валюты", example = "RUB")
    private String toCurency;
}
