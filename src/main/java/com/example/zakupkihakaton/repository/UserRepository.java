package com.example.zakupkihakaton.repository;

import com.example.zakupkihakaton.convert.UserElement;
import com.example.zakupkihakaton.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {
    List<User> findByPIN(String pin);

    List<UserElement> findByTelegramId(String telegramId);
    Page<User> findByDeletedFalse(Pageable pageable);

    List<User> findByDeletedFalseAndRoleId(Short id);

    Boolean existsByRoleId(Short id);
}
