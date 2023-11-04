package com.example.zakupkihakaton.service;

import com.example.zakupkihakaton.convert.UserElement;
import com.example.zakupkihakaton.model.request.UserRequest;
import com.example.zakupkihakaton.model.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse save(UserRequest request);

    UserResponse update(UserRequest request, UUID id);

    UserResponse findById(UUID id);

    Page<UserResponse> findAll(int page, int size);

    List<UserElement> findManagers();

//    List<UserElement>findByTelegramId(String telegramId);

    List<UserElement> findForEvent();

    List<UserElement> findDevelopers();

    @Transactional(readOnly = true)
    Page<UserResponse> findRegion(
            Short regionId,
            int page,
            int size
    );

    @Transactional(readOnly = true)
    Page<UserResponse> findOZ(
            Long OZid,
            int page,
            int size
    );

    void delete(UUID id);

    void restore(UUID id);
}
