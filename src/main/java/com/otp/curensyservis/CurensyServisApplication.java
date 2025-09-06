package com.otp.curensyservis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurensyServisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurensyServisApplication.class, args);
    }

}
