package com.example.amazonagencytt.contoller;

import com.example.amazonagencytt.dto.report.SalesAndTrafficByAsinDto;
import com.example.amazonagencytt.dto.report.SalesAndTrafficByDateDto;
import com.example.amazonagencytt.service.SalesAndTrafficByAsinService;
import com.example.amazonagencytt.service.SalesAndTrafficByDateService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final SalesAndTrafficByDateService salesAndTrafficByDateService;
    private final SalesAndTrafficByAsinService salesAndTrafficByAsinService;

    @GetMapping("/date")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get sales and traffic by date",
            description = "Return all sales and traffic ")
    public List<SalesAndTrafficByDateDto> getSalesAndTrafficByDate() {
        return salesAndTrafficByDateService.findAll();
    }

    @GetMapping("/byAsins")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get sales and traffic by specified asins",
            description = "Return all sales and traffic by asin by specified asins")
    public List<SalesAndTrafficByAsinDto> getSalesAndTrafficByAsins(
            @RequestParam List<String> asins) {
        return salesAndTrafficByAsinService.findAllBySpecifiedAsins(asins);
    }

    @GetMapping("/asin")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get sales and traffic by asin",
            description = "Return all sales and traffic by asin")
    public List<SalesAndTrafficByAsinDto> getSalesAndTrafficByAsin() {
        return salesAndTrafficByAsinService.findAll();
    }

    @GetMapping(value = "/byDate")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get sales and traffic by specified date",
            description = "Return all sales and traffic by date by specified date")
    public SalesAndTrafficByDateDto getSalesAndTrafficByDateBySpecificDate(
            @RequestParam("date") String date) {
        return salesAndTrafficByDateService.getByDate(date);
    }

    @GetMapping(value = "/byAsin")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get sales and traffic by specified asin",
            description = "Return all sales and traffic by asin by specified asin")
    public SalesAndTrafficByAsinDto getSalesAndTrafficByAsinBySpecificAsin(
            @RequestParam String asin) {
        return salesAndTrafficByAsinService.getByAsin(asin);
    }
}
