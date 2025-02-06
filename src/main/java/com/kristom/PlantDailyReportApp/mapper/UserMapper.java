package com.kristom.PlantDailyReportApp.mapper;

import com.kristom.PlantDailyReportApp.domain.dtos.UserDto;
import com.kristom.PlantDailyReportApp.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

}
