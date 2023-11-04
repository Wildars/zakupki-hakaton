package com.example.zakupkihakaton.repository;

import com.example.zakupkihakaton.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Short> {
}
