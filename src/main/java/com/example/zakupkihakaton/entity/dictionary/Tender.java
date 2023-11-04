package com.example.zakupkihakaton.entity.dictionary;

import com.example.zakupkihakaton.entity.Audit;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tender extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
