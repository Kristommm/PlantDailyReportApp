package com.kristom.PlantDailyReportApp.domain.dtos;

import com.kristom.PlantDailyReportApp.domain.Department;
import com.kristom.PlantDailyReportApp.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReportDto {

    private String content;

}
