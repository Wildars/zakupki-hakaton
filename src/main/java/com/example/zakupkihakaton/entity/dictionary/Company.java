package com.example.zakupkihakaton.entity.dictionary;

import com.example.zakupkihakaton.entity.Audit;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String address;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    LicenseType licenseType;
    Boolean license;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    TypeCompany typeCompany;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    TypeOfIndustry typeOfIndustry;

}
