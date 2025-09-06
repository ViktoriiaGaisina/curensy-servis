package com.otp.curensyservis.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    @Bean
    public RequestInterceptor weatherApiKeyInterceptor(@Value("${weatherapi.key}") String apiKey) {
        return template -> {
            // Добавляем ключ как query-параметр для всех запросов к WeatherAPI
            template.query("key", apiKey);
        };
    }

}
