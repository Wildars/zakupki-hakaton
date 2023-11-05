package com.example.zakupkihakaton.entity;


import com.example.zakupkihakaton.entity.dictionary.Tender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
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
    String password;
    String firstName;
    String lastName;
    String patronymic;
    String phone;
    @Column(name = "OZ_name")
    String OZName;
    String jobName;

    String telegramId;


    String username;
    String role;
    String region;
    String organization;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_tender",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tender_id"))
    List<Tender> tenders;

    public boolean isDeleted() {
        return this.getDeleted();
    }
}
