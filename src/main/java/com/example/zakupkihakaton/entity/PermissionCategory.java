package com.example.zakupkihakaton.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Short id;
    String name;

}
