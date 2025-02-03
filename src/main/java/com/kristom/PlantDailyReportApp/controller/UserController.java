package com.kristom.PlantDailyReportApp.controller;

import com.kristom.PlantDailyReportApp.model.dtos.UserDto;
import com.kristom.PlantDailyReportApp.model.entities.UserEntity;
import com.kristom.PlantDailyReportApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto userDto = userService.createUser(user);
        return ResponseEntity.status(201).body(userDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        Optional<UserDto> user = userService.getUserById(id);
        return user.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

}
