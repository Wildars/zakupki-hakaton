package com.example.zakupkihakaton.exception;

public class MyTelegramApiException extends Exception {

    public MyTelegramApiException(String message) {
        super(message);
    }

    public MyTelegramApiException(String message, Throwable cause) {
        super(message, cause);
    }
}