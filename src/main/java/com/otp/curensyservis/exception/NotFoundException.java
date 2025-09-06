package com.otp.curensyservis.exception;

/**
 * Простое кастомное исключение для случаев, когда сущность не найдена.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("not found");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
