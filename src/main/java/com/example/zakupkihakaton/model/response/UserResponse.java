package com.example.zakupkihakaton.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    UUID id;
    String PIN;
    String firstName;
    String lastName;
    String patronymic;
    String jobName;
    String phone;
    String OZName;
    RoleElement role;
}
