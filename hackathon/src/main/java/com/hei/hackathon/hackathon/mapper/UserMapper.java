package com.hei.hackathon.hackathon.mapper;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.exceptions.ResourceNotFoundException;
import com.hei.hackathon.hackathon.services.implementation.CryptoServiceImpl;
import java.util.stream.Collectors;

public class UserMapper {
    private static ToDoMapper toDoMapper;
    public static UserDto MapToUserDto(User user) {
        return new UserDto(
                user.getUname(),
                user.getUserName(),
                user.getEmail(),
                CryptoServiceImpl.decrypts(user.getPassword()),
                user.getToDoLists().stream().map(ToDoMapper::mapToToDoDto).toList()
        );
    }

    public static User MapToUser(UserDto userDto) {
        return new User(
                userDto.getUserName(),
                userDto.getUname(),
                userDto.getEmail(),
                CryptoServiceImpl.encrypts(userDto.getPassword()),
                userDto.getToDoListDtos()
                        .stream()
                        .map(toDoListDto -> ToDoMapper.mapToToDoList(toDoListDto))
                        .toList()
        );
    }
}
