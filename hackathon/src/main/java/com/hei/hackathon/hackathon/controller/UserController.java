package com.hei.hackathon.hackathon.controller;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/users/{userName}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userName) {
        UserDto userDto = userService.getUserById(userName);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/users/authentication")
    public ResponseEntity<Boolean> loginUser(@RequestBody UserDto userDto) {
        Boolean check = userService.checkUserLogin(userDto);
        return (check) ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/users/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto addUser = userService.createUser(userDto);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/update/{userName}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userName") String userName, @RequestBody UserDto userDto) {
        UserDto updateUser = userService.updateUser(userName, userDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/delete/{userName}")
    public String deleteUser(@PathVariable("userName") String  userName) {
        userService.deleteUser(userName);
        return "User deleted with success !";
    }

}
