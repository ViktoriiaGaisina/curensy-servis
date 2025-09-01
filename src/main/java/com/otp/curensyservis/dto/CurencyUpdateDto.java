package com.otp.curensyservis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurencyUpdateDto {
    private String code;
    private String name;
}
