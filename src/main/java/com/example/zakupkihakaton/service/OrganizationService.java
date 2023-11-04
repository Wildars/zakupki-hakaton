package com.example.zakupkihakaton.service;

import com.example.zakupkihakaton.model.request.OrganizationsRequest;
import com.example.zakupkihakaton.model.request.TenderRequest;
import com.example.zakupkihakaton.model.response.OrganizationsResponse;
import com.example.zakupkihakaton.model.response.TenderResponse;
import org.springframework.data.domain.Page;

public interface OrganizationService {
    OrganizationsResponse save(OrganizationsRequest request);

    OrganizationsResponse update(OrganizationsRequest request, Long id);

    OrganizationsResponse findById(Long id);

    Page<OrganizationsResponse> findAll(int page, int size);

    void delete(Long id);
}
