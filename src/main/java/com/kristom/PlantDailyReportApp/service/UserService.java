package com.kristom.PlantDailyReportApp.service;

import com.kristom.PlantDailyReportApp.mapper.UserMapper;
import com.kristom.PlantDailyReportApp.model.dtos.UserDto;
import com.kristom.PlantDailyReportApp.model.entities.UserEntity;
import com.kristom.PlantDailyReportApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(UserDto user){
        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return UserMapper.INSTANCE.userEntityToUserDto(savedUserEntity);
    }

    public Optional<UserDto> getUserById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(UserMapper.INSTANCE::userEntityToUserDto);
    }


    public List<UserDto> getAllUsers() {
        Iterable<UserEntity> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(UserMapper.INSTANCE::userEntityToUserDto)
                .collect(Collectors.toList());
    }
}
