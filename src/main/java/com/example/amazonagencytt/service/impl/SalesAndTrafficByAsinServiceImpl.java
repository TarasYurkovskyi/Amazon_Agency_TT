package com.example.amazonagencytt.service.impl;

import com.example.amazonagencytt.dto.report.SalesAndTrafficByAsinDto;
import com.example.amazonagencytt.mapper.ReportMapper;
import com.example.amazonagencytt.model.report.Report;
import com.example.amazonagencytt.repository.ReportRepository;
import com.example.amazonagencytt.service.SalesAndTrafficByAsinService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesAndTrafficByAsinServiceImpl implements SalesAndTrafficByAsinService {
    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Override
    @Cacheable("salesAndTrafficByAsin")
    public SalesAndTrafficByAsinDto getByAsin(String asin) {
        return reportMapper.toSalesAndTrafficByAsinDto(reportRepository.findByAsin(asin));
    }

    @Override
    @Cacheable("salesAndTrafficByAsins")
    public List<SalesAndTrafficByAsinDto> findAll() {
        List<Report> all = reportRepository.findAll();
        return all.stream()
                .map(reportMapper::toSalesAndTrafficByAsinDto)
                .toList();
    }

    @Override
    @Cacheable("salesAndTrafficBySpecifiedAsins")
    public List<SalesAndTrafficByAsinDto> findAllBySpecifiedAsins(List<String> asins) {
        List<SalesAndTrafficByAsinDto> salesAndTrafficByAsins = new ArrayList<>();
        for (var asin: asins) {
            salesAndTrafficByAsins.add(reportMapper.toSalesAndTrafficByAsinDto(
                    reportRepository.findByAsin(asin)));
        }
        return salesAndTrafficByAsins;
    }
}
