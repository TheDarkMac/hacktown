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

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login/users")
    public ResponseEntity<Boolean> loginUser(@RequestBody UserDto userDto) {
        Boolean check = userService.checkUser(userDto);
        return (check) ? new ResponseEntity<>(true, HttpStatus.FOUND)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto addUser = userService.createUser(userDto);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") long id, @RequestBody UserDto userDto) {
        UserDto updateUser = userService.updateUser(id, userDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "User deleted with success !";
    }

}
