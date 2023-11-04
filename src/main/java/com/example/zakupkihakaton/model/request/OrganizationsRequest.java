package com.example.zakupkihakaton.model.request;

import com.example.zakupkihakaton.entity.Region;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrganizationsRequest {

    String name;
    Long regionId;

}
