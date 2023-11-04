package com.example.zakupkihakaton.repository;

import com.example.zakupkihakaton.entity.dictionary.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderRepository extends JpaRepository<Tender,Long> {
    boolean existsByNumber(String number);
}
