package com.example.amazonagencytt.service.impl;

import com.example.amazonagencytt.model.report.Report;
import com.example.amazonagencytt.repository.ReportRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StatisticsUpdateServiceImpl {
    private final ReportRepository reportRepository;

    @Transactional()
    public void updateStatisticsFromFile(String filePath) {
        try {
            Report updatedReport = readDataFromFile(filePath);
            String reportId = reportRepository.findFirst().getId();
            Report existingReport = reportRepository.findById(reportId).orElse(null);

            if (existingReport != null) {
                existingReport.setReportSpecification(updatedReport.getReportSpecification());
                existingReport.setSalesAndTrafficByAsin(updatedReport.getSalesAndTrafficByAsin());
                existingReport.setSalesAndTrafficByDate(updatedReport.getSalesAndTrafficByDate());
                reportRepository.save(existingReport);
            } else {
                throw new RuntimeException("Report not found with id: " + updatedReport.getId());
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot update db from this file: " + filePath, e);
        }
    }

    private Report readDataFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), Report.class);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file by path: " + filePath);
        }
    }
}
