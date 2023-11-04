package com.example.zakupkihakaton.repository;

import com.example.zakupkihakaton.entity.PermissionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionCategoryRepository extends JpaRepository<PermissionCategory, Short> {
}
