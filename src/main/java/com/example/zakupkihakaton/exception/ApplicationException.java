package com.example.zakupkihakaton.exception;

import org.springframework.http.HttpStatus;

public enum ApplicationException implements CustomError {
    LINK_TO_NULL(HttpStatus.INTERNAL_SERVER_ERROR, "Обращение к null", "Ошибка сервера", "Извините, у нас возникла ошибка на сервере. За дополнительной информацией обратитесь в тех. поддержку."),
    FIELD_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "Класс не имеет поля с таким типом", "Ошибка сервера", "Извините, у нас возникла ошибка на сервере. Не волнуйтесь, мы уже знаем о ней и сейчас в процессе работы. За дополнительной информацией обратитесь в тех. поддержку."),

    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "Неправильный логин или пароль", "Не удалось авторизоваться", "Извините, ваш запрос не может быть обработан, так как указаны неправильный логин или пароль. Пожалуйста, проверьте правильность введенных учетных данных или обратитесь в техническую поддержку за дополнительной помощью."),
    NOT_AUTHORIZED(HttpStatus.UNAUTHORIZED, "Пользователь не авторизован", "Не авторизован", "Извините, для доступа к этому ресурсу необходимо пройти авторизацию. Пожалуйста, авторизуйтесь и попробуйте снова"),

    FILE_READ_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка чтения файла", "Не удалось прочитать файл", "Извините, наш сервер не смог прочесть данный файл. Пожалуйста, проверьте его целостность, убедитесь что его расширение соответствует документам или изображению и попробуйте снова. В случае неудачи обратитесь в техническую поддержку за помощью."),
    FILE_WRITE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка записи файла", "Не удалось записать файл", "Извините, наш сервер не смог записать данные в файл. Просим обратиться в техническую поддержку за помощью."),
    FILE_DELETE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка удаления файла", "Не удалось удалить файл", "Извините, наш сервер не смог удалить данный файл. Пожалуйста, убедитесь в корректности параметров и попробуйте снова. В случае неудачи обратитесь в техническую поддержку за помощью."),
    FILE_IS_EMPTY(HttpStatus.INTERNAL_SERVER_ERROR, "Файл был пуст", "Файл был пуст", "Извините, данный файл был пуст. Пожалуйста, проверьте его целостность и попробуйте снова. В случае неудачи обратитесь в техническую поддержку за помощью."),

    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "Недействительный id", "Запись не найдена", "Извините, данные по вашему запросу не существуют в системе. Пожалуйста, проверьте правильность введенных данных или обратитесь в тех. поддержку за дополнительной информацией."),
    ENTITY_IS_REFERENCED(HttpStatus.BAD_REQUEST, "На обьект ссылаются", "Не удалось удалить", "Извините, на данную запись ссылаются другие данные. В случае, если вы желаете в любом случае продолжить, вы можете удалить связанные с ним данные."),

    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "Сервис недоступен", "Ошибка сервера", "Извините, сторонний сервис, к которому мы обращаемся, в данный момент недоступен. Пожалуйста, попробуйте позже или обратитесь в техническую поддержку."),
    ;
    String reason;
    String title;
    String message;
    HttpStatus status;

    ApplicationException(HttpStatus status, String reason, String title, String message) {
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
