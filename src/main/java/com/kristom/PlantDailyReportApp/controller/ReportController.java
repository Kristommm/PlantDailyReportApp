package com.kristom.PlantDailyReportApp.controller;

import com.kristom.PlantDailyReportApp.domain.dtos.ReportDto;

import com.kristom.PlantDailyReportApp.service.impl.ReportServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reports/")
@RequiredArgsConstructor
public class ReportController {

    private final ReportServiceImpl reportService;

    @PostMapping
    public ResponseEntity<ReportDto> saveReport(@RequestBody ReportDto reportDto){
        ReportDto reportToSave = reportService.saveReport(reportDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(reportToSave);
    }

    @GetMapping
    public ResponseEntity<Page<ReportDto>> getReportsByDepartment(
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ReportDto> reports = reportService.getReports(pageable);
        return ResponseEntity.ok(reports);
    }



}
