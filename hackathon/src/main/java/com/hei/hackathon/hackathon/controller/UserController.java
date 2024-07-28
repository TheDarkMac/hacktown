package com.hei.hackathon.hackathon.controller;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/back/data")
public class UserController {
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        return ResponseEntity.ok(userDtoList);
    }

}
