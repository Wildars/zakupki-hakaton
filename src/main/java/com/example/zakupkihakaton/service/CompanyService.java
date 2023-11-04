package com.example.zakupkihakaton.service;

import com.example.zakupkihakaton.model.request.CompanyRequest;
import com.example.zakupkihakaton.model.request.OrganizationsRequest;
import com.example.zakupkihakaton.model.response.CompanyResponse;
import com.example.zakupkihakaton.model.response.OrganizationsResponse;
import org.springframework.data.domain.Page;

public interface CompanyService {
    CompanyResponse save(CompanyRequest request);

    CompanyResponse update(CompanyRequest request, Long id);

    CompanyResponse findById(Long id);

    Page<CompanyResponse> findAll(int page, int size);

    void delete(Long id);
}
