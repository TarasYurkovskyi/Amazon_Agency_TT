package com.example.amazonagencytt.dto.report;

import com.example.amazonagencytt.model.report.salesandtrafficbyasin.SalesAndTrafficByAsin;
import java.util.List;
import lombok.Data;

@Data
public class SalesAndTrafficByAsinDto {
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
