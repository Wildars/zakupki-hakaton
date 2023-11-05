//package com.example.zakupkihakaton.convert;
//
//import com.example.zakupkihakaton.entity.Permission;
//import com.example.zakupkihakaton.entity.PermissionCategory;
//import com.example.zakupkihakaton.entity.Role;
//import com.example.zakupkihakaton.model.response.PermissionCategoryResponse;
//import com.example.zakupkihakaton.model.response.PermissionResponse;
//import com.example.zakupkihakaton.model.request.RoleRequest;
//import com.example.zakupkihakaton.model.response.RoleResponse;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingTarget;
//import org.mapstruct.NullValuePropertyMappingStrategy;
//
//@Mapper(
//        componentModel = "spring",
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
//        uses = {
//                DefaultMapper.class,
//        }
//)
//public interface RoleMapper {
//    RoleResponse entityToResponse(Role role);
//
//    Role requestToEntity(RoleRequest request);
//
//    //@Mapping(target = "name", ignore = true)
//    void update(@MappingTarget Role role, RoleRequest request);
//
//    PermissionResponse getPermission(Permission permission);
//
//    PermissionCategoryResponse getPermission(PermissionCategory permission);
//
//    default Permission setPermission(Short id) {
//        if (id == null)
//            return null;
//        else
//            return Permission.builder().id(id).build();
//    }
//
//}
