package com.example.amazonagencytt.service;

import com.example.amazonagencytt.dto.report.SalesAndTrafficByAsinDto;
import java.util.List;

public interface SalesAndTrafficByAsinService {

    SalesAndTrafficByAsinDto getByAsin(String asin);

    List<SalesAndTrafficByAsinDto> findAll();

    List<SalesAndTrafficByAsinDto> findAllBySpecifiedAsins(List<String> asins);
}
