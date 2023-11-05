package com.example.zakupkihakaton.model.response;

import com.example.zakupkihakaton.entity.dictionary.Tender;
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
public class UserResponse {
    UUID id;
    String PIN;
    List<TenderResponse> tender;
    String firstName;
    String lastName;
    String patronymic;
    String jobName;
    String phone;
    String OZName;
    String role;
}
