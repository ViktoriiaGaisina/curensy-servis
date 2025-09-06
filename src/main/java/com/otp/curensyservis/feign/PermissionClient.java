package com.otp.curensyservis.feign;

import com.otp.curensyservis.config.FeignConfig;
import com.otp.curensyservis.dto.PermissionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "permission-service", url = "localhost:8081", configuration = FeignConfig.class)
public interface PermissionClient {
    @GetMapping("permission/delete")
    ResponseEntity<PermissionDto> deletePermission(@RequestParam String curencyCode);

    @GetMapping("permission/update")
    ResponseEntity<PermissionDto> getPermissionForUpdate(@RequestParam String curencyCode);

    @GetMapping ("permission/save")
    ResponseEntity<PermissionDto> savePermission(@RequestParam String curencyCode);

}
