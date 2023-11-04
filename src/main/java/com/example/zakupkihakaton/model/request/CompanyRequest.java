package com.example.zakupkihakaton.model.request;

import com.example.zakupkihakaton.entity.dictionary.LicenseType;
import com.example.zakupkihakaton.entity.dictionary.TypeCompany;
import com.example.zakupkihakaton.entity.dictionary.TypeOfIndustry;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyRequest {
    String name;
    String address;

    Long licenseTypeId;
    Boolean license;

    Long typeCompanyID;

    Long typeOfIndustryId;
}
