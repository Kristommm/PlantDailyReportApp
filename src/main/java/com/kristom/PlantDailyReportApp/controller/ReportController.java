package com.kristom.PlantDailyReportApp.controller;

import com.kristom.PlantDailyReportApp.model.dtos.ReportDto;
import com.kristom.PlantDailyReportApp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ResponseEntity<Page<ReportDto>> getAllReports(Pageable pageable){
        Page<ReportDto> reports = reportService.getAllReports(pageable);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

}
