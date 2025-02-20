package com.kristom.PlantDailyReportApp.repository;

import com.kristom.PlantDailyReportApp.domain.Department;
import com.kristom.PlantDailyReportApp.domain.entities.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    Page<Report> findAllByDepartment(Department department, Pageable pageable);

}
