package com.hei.hackathon.hackathon.services.implementation;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.mapper.UserMapper;
import com.hei.hackathon.hackathon.repository.UserRepository;
import com.hei.hackathon.hackathon.services.UserService;
import lombok.SneakyThrows;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @SneakyThrows
    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserMapper::MapToUserDto)
                .toList();
    }
}
