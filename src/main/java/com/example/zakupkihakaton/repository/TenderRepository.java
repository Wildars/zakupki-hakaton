package com.example.zakupkihakaton.repository;

import com.example.zakupkihakaton.entity.dictionary.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Long>, JpaSpecificationExecutor<Tender> {
    boolean existsByNumber(String number);
}
