package com.kristom.PlantDailyReportApp.service.impl;

import com.kristom.PlantDailyReportApp.domain.Department;
import com.kristom.PlantDailyReportApp.domain.dtos.ReportDto;
import com.kristom.PlantDailyReportApp.domain.entities.Report;
import com.kristom.PlantDailyReportApp.domain.entities.User;
import com.kristom.PlantDailyReportApp.mapper.ReportMapper;
import com.kristom.PlantDailyReportApp.repository.ReportRepository;
import com.kristom.PlantDailyReportApp.repository.UserRepository;
import com.kristom.PlantDailyReportApp.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final UserRepository userRepository;

    @Override
    public ReportDto saveReport(ReportDto reportDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authorName = authentication.getName();

        Optional<User> author = userRepository.findByUsername(authorName);
        LocalDateTime now = LocalDateTime.now();

        Report reportToSave = ReportMapper.INSTANCE.toReport(reportDto);
        reportToSave.setAuthor(authorName);
        reportToSave.setDepartment(author.orElseThrow().getDepartment());
        reportToSave.setLocalDateTime(now);

        Report savedReport = reportRepository.save(reportToSave);
        return ReportMapper.INSTANCE.toReportDto(savedReport);
    }

    @Override
    public Page<ReportDto> getReports(Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authorName = authentication.getName();

        Optional<User> author = userRepository.findByUsername(authorName);

        Page<Report> reports = reportRepository.findAllByDepartment(author.orElseThrow().getDepartment(), pageable);
        return reports.map(ReportMapper.INSTANCE::toReportDto);
    }

}
