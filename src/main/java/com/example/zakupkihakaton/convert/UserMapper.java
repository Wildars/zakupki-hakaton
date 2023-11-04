package com.example.zakupkihakaton.convert;


import com.example.zakupkihakaton.entity.Permission;
import com.example.zakupkihakaton.entity.Role;
import com.example.zakupkihakaton.entity.User;
import com.example.zakupkihakaton.model.response.UserAuthResponse;
import com.example.zakupkihakaton.model.request.UserRequest;
import com.example.zakupkihakaton.model.response.UserResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {
                DefaultMapper.class,
                RoleMapper.class,
        }
)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse entityToResponse(User user);

    @Mapping(target = "permissions", source = "role", qualifiedByName = "getPermissions")
    UserAuthResponse entityToAuthResponse(User user);

    UserElement entityToElement(User user);

    @Mapping(target = "role", source = "roleId", qualifiedByName = "setRole")
    @Mapping(target = "region", source = "regionId", qualifiedByName = "setRegion")
    @Mapping(target = "organization", source = "organizationId", qualifiedByName = "setOrganizations")
    User requestToEntity(UserRequest request);

    @Mapping(target = "role", source = "roleId", qualifiedByName = "setRole")
    @Mapping(target = "region", source = "regionId", qualifiedByName = "setRegion")
    @Mapping(target = "organization", source = "organizationId", qualifiedByName = "setOrganizations")
    User update(@MappingTarget User user, UserRequest userRequest);

    @Named("getPermissions")
    default List<String> getPermissions(Role role) {
        if (role.getPermissions() != null)
            return role.getPermissions()
                    .stream()
                    .map(Permission::getName)
                    .collect(Collectors.toList());
        else
            return null;
    }
}
