package com.kristom.PlantDailyReportApp.controller;

import com.kristom.PlantDailyReportApp.domain.dtos.LoginRequestDto;
import com.kristom.PlantDailyReportApp.domain.dtos.LoginResponseDto;
import com.kristom.PlantDailyReportApp.domain.dtos.UserDto;
import com.kristom.PlantDailyReportApp.helper.JwtHelper;
import com.kristom.PlantDailyReportApp.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {


    private final UserServiceImpl userService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody UserDto user){
        UserDto registeredUser = userService.signUp(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        String token = JwtHelper.generateToken(user.getUsername());
        return ResponseEntity.ok(new LoginResponseDto(user.getUsername(), token));
    }

    @GetMapping("/hello")
    public ResponseEntity<String>hello(){
        return ResponseEntity.ok("Hello");
    }

}
