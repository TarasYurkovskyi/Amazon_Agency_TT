package com.example.amazonagencytt.service;

import com.example.amazonagencytt.dto.report.SalesAndTrafficByDateDto;
import java.util.List;

public interface SalesAndTrafficByDateService {
    SalesAndTrafficByDateDto getByDate(String date);

    List<SalesAndTrafficByDateDto> findAll();
}
