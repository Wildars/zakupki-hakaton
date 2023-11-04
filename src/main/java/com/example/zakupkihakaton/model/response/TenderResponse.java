package com.example.zakupkihakaton.model.response;

import com.example.zakupkihakaton.entity.Organizations;
import com.example.zakupkihakaton.entity.dictionary.Company;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TenderResponse {
    String name;
    Company company;
    Organizations organizations;
}
