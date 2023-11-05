package com.example.zakupkihakaton.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    List<Long> tenderId;
    String PIN;
    String OZName;
    String firstName;
    String lastName;
    String patronymic;
    String password;
    String phone;
    String jobName;
    String roleId;
    String regionId;
    String organizationId;
}
