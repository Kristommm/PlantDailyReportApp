package com.kristom.PlantDailyReportApp.controller;

import com.kristom.PlantDailyReportApp.domain.dtos.UserDto;
import com.kristom.PlantDailyReportApp.domain.entities.User;
import com.kristom.PlantDailyReportApp.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody UserDto user){
        userService.signUp(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
