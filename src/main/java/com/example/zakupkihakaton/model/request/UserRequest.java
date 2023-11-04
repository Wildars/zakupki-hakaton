package com.example.zakupkihakaton.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    String PIN;
    String OZName;
    String firstName;
    String lastName;
    String patronymic;
    String password;
    String phone;
    String jobName;
    Short roleId;
    Short informationSystemId;
    Short regionId;
    Long organizationId;
}
