package com.example.zakupkihakaton.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionResponse {
    String title;
    String message;

    public ExceptionResponse(CustomError error) {
        this.message = error.getMessage();
        this.title = error.getTitle();
    }
}
