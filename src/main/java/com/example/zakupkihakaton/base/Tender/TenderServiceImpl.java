package com.example.zakupkihakaton.base.Tender;


import com.example.zakupkihakaton.base.DictServiceImpl;
import com.example.zakupkihakaton.entity.dictionary.Tender;
import com.example.zakupkihakaton.model.request.TenderRequest;
import com.example.zakupkihakaton.model.response.TenderResponse;
import com.example.zakupkihakaton.repository.TenderRepository;
import com.example.zakupkihakaton.specification.TenderSpecification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TenderServiceImpl extends DictServiceImpl<Tender, Long, TenderRepository,
        TenderResponse, TenderRequest, TenderMapper> implements TenderService {
    TenderRepository tenderRepository;
    TenderMapper tenderMapper;

    @Override
    public TenderRepository getRepository() {
        return tenderRepository;
    }

    @Override
    protected Logger getLog() {
        return log;
    }

    @Override
    public TenderMapper getMapper() {
        return tenderMapper;
    }

    @Override
    public Page<TenderResponse> findAll(int page,
                                        int size,
                                        String number,
                                        String type,
                                        String name,
                                        BigDecimal sumFrom,
                                        BigDecimal sumTo,
                                        LocalDateTime dateFrom,
                                        LocalDateTime dateto,
                                        Boolean isStroi) {
        Specification<Tender> specification = new TenderSpecification()
                .findByNumber(number)
                .findByType(type)
                .findByName(name)
                .findSumFrom(sumFrom)
                .findSumTo(sumTo)
                .findStartFrom(dateFrom)
                .findEndTo(dateto)
                .findIsStroi(isStroi);
        Page<Tender> result = tenderRepository.findAll(specification, PageRequest.of(page, size));
        return result.map(tenderMapper::toResponse);
    }

    @Override
    public List<String> getTypes() {
        return Arrays.asList("Товары", "Услуги", "Работы");
    }
}
