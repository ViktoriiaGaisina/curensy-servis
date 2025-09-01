package com.otp.curensyservis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Schema(name = "ExchangeResponseRedDto", description = "Ответ по курсу валют")
public class ExchangeResponseRedDto {
    @Schema(description = "ID курса", example = "9f1b3e1a-1234-4bcd-8ef0-1234567890ab")
    private UUID id;
    @Schema(description = "Курс", example = "84.35")
    private BigDecimal rate;
    @Schema(description = "Дата и время курса", example = "2025-08-28T12:00:00")
    private LocalDateTime date;
    @Schema(description = "Валюта курса")
    private CurencyDto curency;
}

