package com.otp.curensyservis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "CurencyResponseDto", description = "Ответ по валюте")
public class CurencyResponseDto {
    @Schema(description = "ISO код валюты", example = "GBP")
    private String code;
    @Schema(description = "Название валюты", example = "Фунт стерлингов")
    private String name;
}
