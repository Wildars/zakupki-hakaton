package com.example.zakupkihakaton.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionCategoryResponse {
    Short id;
    String name;
    List<PermissionResponse> permissions;
}
