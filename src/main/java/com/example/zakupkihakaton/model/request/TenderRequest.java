package com.example.zakupkihakaton.model.request;


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
public class TenderRequest {
    String name;



    Long companyId;

    Long organizationsId;
}
