package com.kristom.PlantDailyReportApp.domain.dtos;


import com.kristom.PlantDailyReportApp.domain.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDto {

    private String username;

    private String password;

    private Department department;

}
