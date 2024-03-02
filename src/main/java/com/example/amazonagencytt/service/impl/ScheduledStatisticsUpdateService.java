package com.example.amazonagencytt.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class ScheduledStatisticsUpdateService {
    private final StatisticsUpdateServiceImpl statisticsUpdateService;

    @Scheduled(fixedRate = 300)
    public void scheduledUpdate() {
        String filePath = "src/main/resources/test_report.json";
        statisticsUpdateService.updateStatisticsFromFile(filePath);
    }
}
