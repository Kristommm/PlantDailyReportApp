package com.kristom.PlantDailyReportApp.service;

import com.kristom.PlantDailyReportApp.domain.dtos.UserDto;
import org.hibernate.query.Page;

public interface UserService {

    UserDto signUp(UserDto userDto);

}
