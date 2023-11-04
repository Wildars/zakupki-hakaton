package com.example.zakupkihakaton.service.impl;

import com.example.zakupkihakaton.convert.UserElement;
import com.example.zakupkihakaton.convert.UserMapper;
import com.example.zakupkihakaton.entity.Role;
import com.example.zakupkihakaton.entity.User;
import com.example.zakupkihakaton.exception.CustomException;
import com.example.zakupkihakaton.exception.UserException;
import com.example.zakupkihakaton.model.request.UserRequest;
import com.example.zakupkihakaton.model.response.UserResponse;
import com.example.zakupkihakaton.repository.RoleRepository;
import com.example.zakupkihakaton.repository.UserRepository;
import com.example.zakupkihakaton.service.UserService;
import com.example.zakupkihakaton.specification.UserSpecification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    UserMapper userMapper;
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse save(UserRequest request) {
        User entity = userMapper.requestToEntity(request);

        if (entity.getPassword() == null) {
            CustomException exception = new CustomException(UserException.PASSWORD_IS_NULL);
            log.error(exception.getReason(), exception);
            throw exception;
        }
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        User savedEntity = userRepository.save(entity);
        return userMapper.entityToResponse(savedEntity);
    }

    @Override
    @Transactional
    public UserResponse update(UserRequest request, UUID id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> {
                    CustomException exception = new CustomException(UserException.USER_NOT_FOUND);
                    log.error(exception.getReason(), exception);
                    throw exception;
                });

        if (entity.isDeleted()) {
            CustomException exception = new CustomException(UserException.USER_DELETED);
            log.error(exception.getReason(), exception);
            throw exception;
        }

        userMapper.update(entity, request);

        if (entity.getPassword() == null) {
            CustomException exception = new CustomException(UserException.PASSWORD_IS_NULL);
            log.error(exception.getReason(), exception);
            throw exception;
        }

        if (request.getPassword() != null)
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        User savedEntity = userRepository.save(entity);
        return userMapper.entityToResponse(savedEntity);
    }

    @Override
    public UserResponse findById(UUID id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> {
                    CustomException exception = new CustomException(UserException.USER_NOT_FOUND);
                    log.error(exception.getReason(), exception);
                    throw exception;
                });

        if (entity.isDeleted()) {
            CustomException exception = new CustomException(UserException.USER_DELETED);
            log.error(exception.getReason(), exception);
            throw exception;
        }


        User savedEntity = userRepository.save(entity);
        return userMapper.entityToResponse(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserResponse> findAll(int page, int size) {
        Page<User> entityPage = userRepository.findByDeletedFalse(PageRequest.of(page, size));
        return entityPage.map(userMapper::entityToResponse);
    }

    @Override
    public List<UserElement> findManagers() {
        //retraining:accept
        List<Role> roles = roleRepository.findByPermissionsId((short) 14);
        HashSet<User> managers = new HashSet<>();

        for (Role i : roles) {
            managers.addAll(userRepository.findByDeletedFalseAndRoleId(i.getId()));
        }

        return managers.stream()
                .map(userMapper::entityToElement)
                .collect(Collectors.toList());
    }



//    @Override
//    public List<UserElement> findByTelegramId(String telegramId) {
//        List<Role> roles = roleRepository.findByPermissionsId((short) 14);
//        HashSet<User> managers = new HashSet<>();
//
//        for (Role i : roles) {
//            managers.addAll(userRepository.findByDeletedFalseAndRoleId(i.getId()));
//        }
//        return managers.stream()
//                .map(userMapper::entityToElement)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<UserElement> findForEvent() {
        List<Role> roles = roleRepository.findByPermissionsId((short) 31);
        HashSet<User> managers = new HashSet<>();

        for (Role i : roles) {
            managers.addAll(userRepository.findByDeletedFalseAndRoleId(i.getId()));
        }

        return managers.stream()
                .map(userMapper::entityToElement)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserElement> findDevelopers() {
        //contacting:do_task
        List<Role> roles = roleRepository.findByPermissionsId((short) 12);
        HashSet<User> managers = new HashSet<>();

        for (Role i : roles) {
            managers.addAll(userRepository.findByDeletedFalseAndRoleId(i.getId()));
        }

        return managers.stream()
                .map(userMapper::entityToElement)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserResponse> findRegion(
            Short regionId,
            int page,
            int size
    ) {

        //contacting:role_region
        List<Role> roles = new ArrayList<>(roleRepository.findByPermissionsId((short) 23));

        Specification<User> specification = new UserSpecification()
                .findByRoleList(roles)
                .findByRegionId(regionId);

        Page<User> users = userRepository.findAll(specification, PageRequest.of(page, size));

        return users.map(userMapper::entityToResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserResponse> findOZ(
            Long OZid,
            int page,
            int size
    ) {

        List<Role> roles = new ArrayList<>(roleRepository.findByPermissionsId((short) 24));

        Specification<User> specification = new UserSpecification()
                .findByRoleList(roles)
                .findByOZid(OZid);

        Page<User> users = userRepository.findAll(specification, PageRequest.of(page, size));

        return users.map(userMapper::entityToResponse);
    }


    @Override
    public void delete(UUID id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> {
                    CustomException exception = new CustomException(UserException.USER_NOT_FOUND);
                    log.error(exception.getReason(), exception);
                    throw exception;
                });

        entity.setDeleted(true);

        userRepository.save(entity);
    }

    @Override
    public void restore(UUID id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> {
                    CustomException exception = new CustomException(UserException.USER_NOT_FOUND);
                    log.error(exception.getReason(), exception);
                    throw exception;
                });

        entity.setDeleted(false);

        userRepository.save(entity);
    }
}
