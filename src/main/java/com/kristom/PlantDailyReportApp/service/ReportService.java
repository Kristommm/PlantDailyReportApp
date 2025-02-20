package com.kristom.PlantDailyReportApp.service;

import com.kristom.PlantDailyReportApp.domain.Department;
import com.kristom.PlantDailyReportApp.domain.dtos.ReportDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportService {

    ReportDto saveReport(ReportDto reportDto);

    Page<ReportDto> getReports(Pageable pageable);

}
