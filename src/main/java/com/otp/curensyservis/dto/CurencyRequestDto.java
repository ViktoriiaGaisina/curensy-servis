package com.otp.curensyservis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "CurencyRequestDto", description = "Запрос на создание валюты")
public class CurencyRequestDto {
    @Schema(description = "ISO код валюты", example = "EUR", requiredMode = Schema.RequiredMode.REQUIRED)
    private String code;
    @Schema(description = "Название валюты", example = "Евро", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

}
