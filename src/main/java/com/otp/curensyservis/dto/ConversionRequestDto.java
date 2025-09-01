package com.otp.curensyservis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@Schema(name = "ConversionRequestDto", description = "Запрос на создание конвертации")
public class ConversionRequestDto {
    @Schema(description = "Исходная сумма", example = "100.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal amount;
    @Schema(description = "Сконвертированная сумма (необязательно при создании)", example = "9200.00")
    private BigDecimal convertedAmount;
    @Schema(description = "Курс конвертации", example = "92.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal rate;
    @Schema(description = "Код целевой валюты", example = "RUB", requiredMode = Schema.RequiredMode.REQUIRED)
    private String toCurencyCode;
    @Schema(description = "Код исходной валюты", example = "USD", requiredMode = Schema.RequiredMode.REQUIRED)
    private String fromCurencyCode;
}
