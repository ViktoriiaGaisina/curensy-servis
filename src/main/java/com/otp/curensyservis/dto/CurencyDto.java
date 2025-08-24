package com.otp.curensyservis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurencyDto {
    private String code;
    private String name;
}
