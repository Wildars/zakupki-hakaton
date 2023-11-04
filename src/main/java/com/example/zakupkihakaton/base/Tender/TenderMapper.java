package com.example.zakupkihakaton.base.Tender;

import com.example.zakupkihakaton.base.BaseMapper;
import com.example.zakupkihakaton.base.DictMapper;
import com.example.zakupkihakaton.convert.DefaultMapper;
import com.example.zakupkihakaton.entity.dictionary.Tender;
import com.example.zakupkihakaton.model.request.TenderRequest;
import com.example.zakupkihakaton.model.response.TenderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {
                DefaultMapper.class,
        }
)
public interface TenderMapper extends DictMapper<Tender, TenderResponse, TenderRequest> {
}
