package com.example.zakupkihakaton.base.Tender;

import com.example.zakupkihakaton.base.DictController;
import com.example.zakupkihakaton.model.request.TenderRequest;
import com.example.zakupkihakaton.model.response.TenderResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/tender")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TenderController extends DictController<Long, TenderResponse, TenderRequest, TenderService> {
    TenderService tenderService;

    @Override
    protected TenderService getService() {
        return tenderService;
    }

    @GetMapping("/")
    public Page<TenderResponse> findAll(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "25") int size,
                                        @RequestParam(required = false) String number,
                                        @RequestParam(required = false) String type,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) BigDecimal sumFrom,
                                        @RequestParam(required = false) BigDecimal sumTo,
                                        @RequestParam(required = false) LocalDateTime dateFrom,
                                        @RequestParam(required = false) LocalDateTime dateto,
                                        @RequestParam(required = false) Boolean isStroi
    ) {
        return tenderService.findAll(
                page,
                size,
                number,
                type,
                name,
                sumFrom,
                sumTo,
                dateFrom,
                dateto,
                isStroi
        );
    }
}
