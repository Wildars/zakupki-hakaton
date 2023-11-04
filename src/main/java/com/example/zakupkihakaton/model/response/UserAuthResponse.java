package com.example.zakupkihakaton.model.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAuthResponse {
    UUID id;
    String PIN;
    String firstName;
    String lastName;
    String patronymic;
    String phone;
    String OZName;
    String jobName;
    RoleElement role;
    List<String> permissions;

}
