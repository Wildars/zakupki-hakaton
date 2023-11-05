package com.example.zakupkihakaton.model.response;


import com.example.zakupkihakaton.entity.dictionary.Company;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TenderResponse {
    Long id;
    String number;
    String organization;
    String type;
    String name;
    BigDecimal sum;
    LocalDateTime dateStart;
    LocalDateTime dateEnd;
    Boolean isStroi;
}
