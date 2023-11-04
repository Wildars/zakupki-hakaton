package com.example.zakupkihakaton.repository;

import com.example.zakupkihakaton.entity.dictionary.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
