package com.example.zakupkihakaton.service;

import com.example.zakupkihakaton.model.request.TenderRequest;
import com.example.zakupkihakaton.model.request.UserRequest;
import com.example.zakupkihakaton.model.response.TenderResponse;
import org.springframework.data.domain.Page;



public interface TenderService {
    TenderResponse save(TenderRequest request);

    TenderResponse update(TenderRequest request, Long id);

    TenderResponse findById(Long id);

    Page<TenderResponse> findAll(int page, int size);

    void delete(Long id);
}
