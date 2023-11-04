package com.example.zakupkihakaton.exception;

import org.springframework.http.HttpStatus;

public enum RoleException implements CustomError {
    ROLE_NOT_FOUND(HttpStatus.NOT_FOUND, "role с таким id в бд не найден", "Роль не найдена", "Извините, указанная роль не существует в системе. Пожалуйста, проверьте правильность введенных данных или обратитесь в тех. поддержку за дополнительной информацией."),
    ;

    String reason;
    String title;
    String message;
    HttpStatus status;

    RoleException(HttpStatus status, String reason, String title, String message) {
        this.status = status;
        this.reason = reason;
        this.title = title;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getReason() {
        return this.reason;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }
}
