package com.example.zakupkihakaton.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomError {
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "Сущность с этим id не найден", "Не найдено"),
    ENTITY_DELETED(HttpStatus.GONE, "Сущность с этим id был удален", "Удалено"), //TODO: Админ будет видеть
    ENTITY_IS_REFERENCED(HttpStatus.CONFLICT, "На Сущность еще ссылается другие Сущности", "Имеются зависимости"),
    ENTITY_BAD_DATA(HttpStatus.BAD_REQUEST, "Неправильные данные запроса", "Неправильный запрос"),

    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "Неправильный логин или пароль", "Не удалось авторизоваться"),
    NOT_AUTHORIZED(HttpStatus.UNAUTHORIZED, "Пользователь не авторизован", "Не авторизован"),
    TOKEN_IS_EXPIRED(HttpStatus.UNAUTHORIZED, "Время авторизации закончилось", "Пройдите авторизацию"),
    TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "Недействительная авторизация", "Пройдите авторизацию"),

    USER_NOT_ACTIVE(HttpStatus.BAD_REQUEST, "Пользователь не активен", "Пройдите верификацию"),

    GATEWAY_NOT_ASK(HttpStatus.BAD_GATEWAY, "Нет доступа к стороннему ресурсу", "Нет ответа"),
    GATEWAY_TIMEOUT(HttpStatus.GATEWAY_TIMEOUT, "Сторонний ресурс не отвечает", "Превышен лимит ответа"),

    IO_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Не удалось взаимодействовать с файлом", "Ошибка файла"),
    SERVLET_EXCEPTION(HttpStatus.BAD_REQUEST, "Запрос не получилось обработать", "Необрабатываемый запрос"),
    MESSAGE_EXCEPTION(HttpStatus.BAD_REQUEST, "Не удалось отправить сообщение", "Не удалось отправить сообщение"),


    PASSWORD_IS_NULL(HttpStatus.BAD_REQUEST, "Пароль пуст", "Недействительный пароль");
    HttpStatus status;
    String message;
    String title;

}
