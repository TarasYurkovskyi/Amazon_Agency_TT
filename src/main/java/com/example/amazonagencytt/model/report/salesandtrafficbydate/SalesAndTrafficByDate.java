package com.example.amazonagencytt.model.report.salesandtrafficbydate;

import lombok.Data;

@Data
public class SalesAndTrafficByDate {
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
