package com.example.zakupkihakaton.exception;

import com.example.zakupkihakaton.util.JsonUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
    JsonUtil jsonUtil;

    private void errorLog(Exception e, HttpServletRequest request, HttpServletResponse response) {
        String row = String.format(
                "%s\tError:%s --- %s",
                request.getAttribute("requestId"),
                e.toString(),
                jsonUtil.convertToCurl(request)
        );

        log.error(row, e);
    }

    private void errorLog(CustomException e, HttpServletRequest request, HttpServletResponse response) {
        String row = String.format(
                "%s\tError:%s --- %s",
                request.getAttribute("requestId"),
                e.toString(),
                jsonUtil.convertToCurl(request)
        );

        e.getLogger().error(row, e);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleException(
            CustomException e,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        errorLog(e, request, response);
        return new ResponseEntity<>(e.getResponse(), e.getStatus());
    }

    @ExceptionHandler(HibernateException.class)
    public ResponseEntity<ExceptionResponse> handleException(
            HibernateException e,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ) {
        errorLog(e, httpServletRequest, httpServletResponse);
        ExceptionResponse response = new ExceptionResponse(e.getLocalizedMessage(), "Ошибка базы данных");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException e) {
        List<String> messages = new ArrayList<>();
        for (var er : e.getBindingResult().getFieldErrors())
            messages.add(er.getField() + ": " + er.getDefaultMessage());
        for (var er : e.getBindingResult().getGlobalErrors())
            messages.add(er.getObjectName() + ": " + er.getDefaultMessage());

        ExceptionResponse response = new ExceptionResponse(
                "Ошибка валидации",
                String.join("\n", messages)
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
