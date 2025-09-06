package com.otp.curensyservis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PermissionDto {
    private String curencyCode;
    private Boolean permission;
}
