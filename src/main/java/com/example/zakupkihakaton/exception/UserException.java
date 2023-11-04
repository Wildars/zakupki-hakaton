package com.example.zakupkihakaton.exception;

import org.springframework.http.HttpStatus;

public enum UserException implements CustomError {
    PASSWORD_IS_NULL(HttpStatus.BAD_REQUEST, "пароль - null", "Неполные данные запроса", "Извините, ваш запрос не включает в себя пароль. Пожалуйста, добавьте его в ваш запрос и повторите снова."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User с таким id в бд не найден", "Пользователь не найден", "Извините, указанный пользователь не существует в системе. Пожалуйста, проверьте правильность введенных данных или обратитесь в тех. поддержку за дополнительной информацией."),
    USER_DELETED(HttpStatus.GONE, "User с таким id удален", "Пользователь удален", "Извините, указанный пользователь удален, хотя и существует в системе. Если вам принадлежал указанный аккаунт, то обратитесь в тех. поддержку с запросом об восстановлении."),
    ;

    String reason;
    String title;
    String message;
    HttpStatus status;

    UserException(HttpStatus status, String reason, String title, String message) {
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
