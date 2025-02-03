package com.kristom.PlantDailyReportApp.model.dtos;

import com.kristom.PlantDailyReportApp.model.enums.Role;
import com.kristom.PlantDailyReportApp.model.entities.ReportEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String password;

    private Role role;

}
