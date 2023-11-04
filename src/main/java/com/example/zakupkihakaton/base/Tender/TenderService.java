package com.example.zakupkihakaton.base.Tender;

import com.example.zakupkihakaton.base.DictService;
import com.example.zakupkihakaton.model.request.TenderRequest;
import com.example.zakupkihakaton.model.response.TenderResponse;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TenderService extends DictService<Long, TenderResponse, TenderRequest> {
    Page<TenderResponse> findAll(int page,
                                 int size,
                                 String number,
                                 String type,
                                 String name,
                                 BigDecimal sumFrom,
                                 BigDecimal sumTo,
                                 LocalDateTime dateFrom,
                                 LocalDateTime dateto,
                                 Boolean isStroi
    );

    List<String> getTypes();
}
