package com.example.amazonagencytt.service.impl;

import com.example.amazonagencytt.dto.report.SalesAndTrafficByDateDto;
import com.example.amazonagencytt.mapper.ReportMapper;
import com.example.amazonagencytt.model.report.Report;
import com.example.amazonagencytt.repository.ReportRepository;
import com.example.amazonagencytt.service.SalesAndTrafficByDateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesAndTrafficByDateServiceImpl implements SalesAndTrafficByDateService {
    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Override
    @Cacheable("salesAndTrafficByDate")
    public SalesAndTrafficByDateDto getByDate(String date) {
        return reportMapper.toSalesAndTrafficByDateDto(reportRepository.findByDate(date));
    }

    @Override
    @Cacheable("salesAndTrafficByDates")
    public List<SalesAndTrafficByDateDto> findAll() {
        List<Report> all = reportRepository.findAll();
        return all.stream()
                .map(reportMapper::toSalesAndTrafficByDateDto)
                .toList();
    }
}
