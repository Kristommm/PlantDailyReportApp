package com.kristom.PlantDailyReportApp.service;

import com.kristom.PlantDailyReportApp.mapper.ReportMapper;
import com.kristom.PlantDailyReportApp.model.dtos.ReportDto;
import com.kristom.PlantDailyReportApp.model.entities.ReportEntity;
import com.kristom.PlantDailyReportApp.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;


    public ReportDto createReport(ReportEntity report){
        ReportEntity savedReport = reportRepository.save(report);
        return ReportMapper.INSTANCE.reportEntityToReportDto(savedReport);
    }

    public Optional<ReportDto> getReportById(Long id){
        Optional<ReportEntity> report = reportRepository.findById(id);
        return report.map(ReportMapper.INSTANCE::reportEntityToReportDto);

    }

    public Page<ReportDto> getAllReports(Pageable pageable){
        Page<ReportEntity> reports = reportRepository.findAll(pageable);
        return reports.map(ReportMapper.INSTANCE::reportEntityToReportDto);
    }

}
