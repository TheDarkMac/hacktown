package com.hei.hackathon.hackathon.services.implementation;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.mapper.UserMapper;
import com.hei.hackathon.hackathon.repository.UserRepository;
import com.hei.hackathon.hackathon.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
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
