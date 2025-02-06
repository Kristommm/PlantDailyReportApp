package com.kristom.PlantDailyReportApp.domain.dtos;

import com.kristom.PlantDailyReportApp.domain.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    private String username;

    private String password;

    private Role role;

}