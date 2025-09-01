package com.otp.curensyservis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
@Schema(name = "ExchangeRequestRedDto", description = "Запрос на создание записи курса")
public class ExchangeRequestRedDto {
    @Schema(description = "Курс", example = "92.10", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal rate;
    @Schema(description = "Дата и время курса", example = "2025-08-28T12:00:00")
    private LocalDateTime date;
    @Schema(description = "Валюта курса", requiredMode = Schema.RequiredMode.REQUIRED)
    private CurencyDto curency;
}

