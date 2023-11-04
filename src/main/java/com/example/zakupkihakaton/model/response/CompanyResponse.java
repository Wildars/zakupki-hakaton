package com.example.zakupkihakaton.model.response;

import com.example.zakupkihakaton.entity.dictionary.LicenseType;
import com.example.zakupkihakaton.entity.dictionary.TypeCompany;
import com.example.zakupkihakaton.entity.dictionary.TypeOfIndustry;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyResponse {
    String name;
    String address;
    LicenseType licenseType;
    Boolean license;
    TypeCompany typeCompany;
    TypeOfIndustry typeOfIndustry;
}
