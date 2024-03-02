package com.example.amazonagencytt.mapper;

import com.example.amazonagencytt.config.MapperConfig;
import com.example.amazonagencytt.dto.report.SalesAndTrafficByAsinDto;
import com.example.amazonagencytt.dto.report.SalesAndTrafficByDateDto;
import com.example.amazonagencytt.model.report.Report;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ReportMapper {
    SalesAndTrafficByDateDto toSalesAndTrafficByDateDto(Report report);

    SalesAndTrafficByAsinDto toSalesAndTrafficByAsinDto(Report report);

    Report toReport(SalesAndTrafficByDateDto salesAndTrafficByDateDto);
}
