//package com.example.zakupkihakaton.service.impl;
//
//import com.example.zakupkihakaton.convert.RoleMapper;
//import com.example.zakupkihakaton.entity.PermissionCategory;
//import com.example.zakupkihakaton.entity.Role;
//import com.example.zakupkihakaton.exception.CustomError;
//import com.example.zakupkihakaton.exception.CustomException;
//import com.example.zakupkihakaton.model.request.RoleRequest;
//import com.example.zakupkihakaton.model.response.PermissionCategoryResponse;
//import com.example.zakupkihakaton.model.response.RoleResponse;
//import com.example.zakupkihakaton.repository.PermissionCategoryRepository;
//import com.example.zakupkihakaton.repository.PermissionRepository;
//import com.example.zakupkihakaton.repository.RoleRepository;
//import com.example.zakupkihakaton.repository.UserRepository;
//import com.example.zakupkihakaton.service.RoleService;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//@Slf4j
//public class RoleServiceImpl implements RoleService {
//    RoleMapper roleMapper;
//    UserRepository userRepository;
//    RoleRepository roleRepository;
//    PermissionRepository permissionRepository;
//    PermissionCategoryRepository permissionCategoryRepository;
//
//    @Override
//    public RoleResponse create(RoleRequest request) {
//        Role entity = roleMapper.requestToEntity(request);
//        Role savedEntity = roleRepository.save(entity);
//        return roleMapper.entityToResponse(savedEntity);
//    }
//
//    @Override
//    public RoleResponse update(RoleRequest request, Short id) {
//        Role entity = roleRepository.findById(id)
//                .orElseThrow(() -> new CustomException(CustomError.ENTITY_NOT_FOUND, log));
//
//        roleMapper.update(entity, request);
//
//        Role savedEntity = roleRepository.save(entity);
//        return roleMapper.entityToResponse(savedEntity);
//    }
//
//    @Override
//    public RoleResponse findById(Short id) {
//        Role entity = roleRepository.findById(id)
//                .orElseThrow(() -> new CustomException(CustomError.ENTITY_NOT_FOUND, log));
//
//        Role savedEntity = roleRepository.save(entity);
//        return roleMapper.entityToResponse(savedEntity);
//    }
//
//    @Override
//    public List<RoleResponse> findAll() {
//        List<Role> roles = roleRepository.findAll();
//        return roles.stream()
//                .map(roleMapper::entityToResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<PermissionCategoryResponse> getPermissions() {
//        List<PermissionCategory> permissions = permissionCategoryRepository.findAll();
//        return permissions.stream()
//                .map(roleMapper::getPermission)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Boolean delete(Short id) {
//        Role entity = roleRepository.findById(id)
//                .orElseThrow(() -> new CustomException(CustomError.ENTITY_NOT_FOUND, log));
//
//        if (userRepository.existsByRoleId(id))
//            return false;
//
//        roleRepository.delete(entity);
//        return true;
//    }
//}
