package com.kristom.PlantDailyReportApp.mapper;

import com.kristom.PlantDailyReportApp.model.dtos.UserDto;
import com.kristom.PlantDailyReportApp.model.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userEntityToUserDto(UserEntity user);

    UserEntity userDtoToUserEntity(UserDto user);

}
