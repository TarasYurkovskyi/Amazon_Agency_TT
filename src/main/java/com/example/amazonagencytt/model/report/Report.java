package com.example.amazonagencytt.model.report;

import com.example.amazonagencytt.model.report.salesandtrafficbyasin.SalesAndTrafficByAsin;
import com.example.amazonagencytt.model.report.salesandtrafficbydate.SalesAndTrafficByDate;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reports")
public class Report {
    @Id
    private String id;
    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
