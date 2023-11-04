package com.example.zakupkihakaton.entity.dictionary;

import com.example.zakupkihakaton.entity.Audit;
import com.example.zakupkihakaton.entity.Organizations;
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
public class Tender extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    Company company;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    Organizations organizations;

}
