package com.kristom.PlantDailyReportApp.service.impl;


import com.kristom.PlantDailyReportApp.domain.dtos.UserDto;
import com.kristom.PlantDailyReportApp.domain.entities.User;
import com.kristom.PlantDailyReportApp.mapper.UserMapper;
import com.kristom.PlantDailyReportApp.repository.UserRepository;
import com.kristom.PlantDailyReportApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void signUp(UserDto userDto){
        String username = userDto.getUsername();
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()){
            throw new DuplicateKeyException(String.format("%s is already taken", username));
        }
        User user = UserMapper.INSTANCE.toUser(userDto);
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

}
