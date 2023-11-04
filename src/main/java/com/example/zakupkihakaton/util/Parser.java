package com.example.zakupkihakaton.util;

import com.example.zakupkihakaton.entity.dictionary.Tender;
import com.example.zakupkihakaton.repository.TenderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class Parser {
    TenderRepository tenderRepository;

    @Scheduled(initialDelay = 0, fixedDelay = 1000 * 60 * 60 * 24)
    public void sync() {
        String url = "https://zakupki.okmot.kg/popp/view/order/list.xhtml";
        Document doc = null;
        try {
            doc = Jsoup
                    .connect(url)
                    .header("Accept-Encoding", "gzip, deflate")
                    .maxBodySize(0)
                    .timeout(1000 * 60)
                    .get();
        } catch (IOException e) {
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        var all = doc.selectFirst("div.ui-datatable-tablewrapper > table").selectFirst("tbody");
        for (var tr : all.select("tr")) {
            var tds = tr.select("td");
            String[] data = new String[9];

            for (int i = 0; i < tds.size(); i++) {
                Element span = tds.get(i).selectFirst("span");
                if (span != null) {
                    data[i] = span.nextSibling().toString().trim();
                }
            }

            String number = data[0];
            if (!tenderRepository.existsByNumber(number)) {
                String organizationName = data[1];
                String zakupkiType = null;
                switch (data[2]) {
                    case "work":
                        zakupkiType = "Работы";
                        break;
                    case "Goods":
                        zakupkiType = "Товары";
                        break;
                    case "services":
                        zakupkiType = "Услуги";
                        break;
                }
                String zakupkiName = Jsoup.parse(data[3]).text();

                BigDecimal sum = null;
                String str = data[6];
                str = str.replace(",", "");
                try {
                    sum = new BigDecimal(str);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }

                String dateStart = data[7];
                String dateEnd = data[8];
                boolean isStroi = zakupkiName.toUpperCase().contains("СТРО");

                Tender tender = new Tender();
                tender.setNumber(number);
                tender.setOrganization(organizationName);
                tender.setType(zakupkiType);
                tender.setName(zakupkiName);
                tender.setSum(sum);
                tender.setDateStart(LocalDateTime.parse(dateStart, formatter));
                tender.setDateEnd(LocalDateTime.parse(dateEnd, formatter));
                tender.setIsStroi(isStroi);

                tenderRepository.save(tender);
            }
        }
    }
}


