package com.kristom.PlantDailyReportApp.repository;

import com.kristom.PlantDailyReportApp.model.entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
