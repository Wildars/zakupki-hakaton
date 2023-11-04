package com.example.zakupkihakaton.convert;


import com.example.zakupkihakaton.entity.Organizations;
import com.example.zakupkihakaton.entity.Region;
import com.example.zakupkihakaton.entity.Role;
import com.example.zakupkihakaton.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface DefaultMapper {


    @Named("setOrganizations")
    default Organizations setOrganizations(Long id) {
        if (id == null)
            return null;

        return Organizations.builder().id(id).build();
    }

    @Named("setUser")
    default User setUser(UUID source) {
        if (source == null)
            return null;

        return User.builder().id(source).build();
    }

    @Named("setRegion")
    default Region toRegion(Short id) {
        if (id == null) {
            return null;
        }
        return Region.builder().id(id).build();
    }

    @Named("setRole")
    default Role setRole(Short id) {
        if (id == null)
            return null;
        return Role.builder().id(id).build();
    }

//    @Named("getDevelopers")
//    default List<UserElement> getDevelopers(List<User> users) {
//        if (users == null)
//            return null;
//
//        List<UserElement> result = new ArrayList<>();
//        for (User i : users)
//            result.add(new UserElement(i.getId(), setFIO(i)));
//
//        return result;
//    }



    default LocalDateTime mapToLocalDateTime(LocalDate localDate) {
        return localDate.atStartOfDay();
    }
}
