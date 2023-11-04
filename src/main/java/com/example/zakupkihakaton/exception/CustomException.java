package com.example.zakupkihakaton.exception;

import com.example.zakupkihakaton.model.response.ExceptionResponse;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomException extends RuntimeException {
    private ExceptionResponse response;
    private HttpStatus status;

    public <E extends CustomError> CustomException(E error) {
        this.response = new ExceptionResponse(
                error.getReason(),
                error.getTitle(),
                error.getMessage()
        );
        this.status = error.getStatus();
    }

    public <E extends CustomError> CustomException(E error, HttpStatus status) {
        this.response = new ExceptionResponse(
                error.getReason(),
                error.getTitle(),
                error.getMessage()
        );
        this.status = status;
    }

    @Override
    public String getMessage() {
        return response.getMessage();
    }

    public String getReason() {
        return response.getReason();
    }
}
