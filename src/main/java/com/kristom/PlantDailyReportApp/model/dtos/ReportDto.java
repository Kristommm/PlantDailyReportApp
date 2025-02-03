package com.kristom.PlantDailyReportApp.model.dtos;

import com.kristom.PlantDailyReportApp.model.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportDto {

    private Long id;
    private String message;
    private LocalDateTime dateTime;
    private UserEntity user;

}
