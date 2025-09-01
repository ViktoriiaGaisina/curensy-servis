package com.otp.curensyservis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
@Schema(name = "ConversionUpdateRequestDto", description = "Запрос на обновление конвертации")
public class ConversionUpdateRequestDto {
    @Schema(description = "Исходная сумма", example = "120.00")
    private BigDecimal amount;
    @Schema(description = "Сконвертированная сумма", example = "11040.00")
    private BigDecimal convertedAmount;
    @Schema(description = "Курс конвертации", example = "92.00")
    private BigDecimal rate;
    @Schema(description = "Код целевой валюты", example = "RUB")
    private String toCurencyCode;
    @Schema(description = "Код исходной валюты", example = "USD")
    private String fromCurencyCode;
}
