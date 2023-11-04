package com.example.zakupkihakaton.convert;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserElement {
    UUID id;
    String FIO;
    String telegramId;
    String username;
}
