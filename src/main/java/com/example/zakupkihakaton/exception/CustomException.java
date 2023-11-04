package com.example.zakupkihakaton.exception;

import lombok.Data;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;

@Data
public class CustomException extends RuntimeException {
    private ExceptionResponse response;
    private HttpStatus status;
    private Logger logger;

    public CustomException(CustomError error, Logger logger) {
        this.response = new ExceptionResponse(error);
        this.status = error.getStatus();
        this.logger = logger;
    }

    @Override
    public String getMessage() {
        return response.getMessage();
    }
}
