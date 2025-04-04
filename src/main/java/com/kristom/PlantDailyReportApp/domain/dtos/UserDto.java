package com.kristom.PlantDailyReportApp.domain.dtos;

import com.kristom.PlantDailyReportApp.domain.Department;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String username;

    private String password;

    private Department department;

}