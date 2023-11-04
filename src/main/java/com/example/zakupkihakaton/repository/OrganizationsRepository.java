package com.example.zakupkihakaton.repository;

import com.example.zakupkihakaton.entity.Organizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationsRepository extends JpaRepository<Organizations,Long> {
}
