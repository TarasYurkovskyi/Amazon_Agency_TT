package com.example.amazonagencytt.repository;

import com.example.amazonagencytt.model.report.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ReportRepository extends MongoRepository<Report, String> {

    @Query(value = "SELECT report FROM r report ORDER BY report.z")
    Report findFirst();

    @Query(value = "{'salesAndTrafficByDate.date': ?0}", fields = "{'salesAndTrafficByDate.$': 1}")
    Report findByDate(String date);

    @Query(value = "{'salesAndTrafficByAsin.parentAsin': ?0}",
            fields = "{'salesAndTrafficByAsin.$': 1}")
    Report findByAsin(String asin);
}
