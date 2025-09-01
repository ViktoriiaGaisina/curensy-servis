package com.otp.curensyservis.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "CurencyDto", description = "Представление валюты")
public class CurencyDto {
    @Schema(description = "ISO код валюты", example = "USD")
    private String code;
    @Schema(description = "Название валюты", example = "Доллар США")
    private String name;
}
