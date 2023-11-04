package com.example.zakupkihakaton.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends Audit<String> {
    @Id
    @GenericGenerator(name = "id", strategy = "kg.tech.support.Util.util.UUID7")
    @GeneratedValue
    UUID id;
    String PIN;
    String firstName;
    String lastName;
    String patronymic;
    String password;
    String phone;
    @Column(name = "OZ_name")
    String OZName;
    String jobName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    Role role;

    String telegramId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    Region region;

    String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    Organizations organization;

    public boolean isDeleted() {
        return this.getDeleted();
    }
}
