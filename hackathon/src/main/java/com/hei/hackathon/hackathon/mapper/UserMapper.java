package com.hei.hackathon.hackathon.mapper;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.services.implementation.CryptoServiceImpl;

public class UserMapper {
    public static UserDto MapToUserDto(User user) {
        return new UserDto(
                user.getUname(),
                user.getUserName(),
                user.getEmail(),
                CryptoServiceImpl.decrypts(user.getPassword()),
                user.getToDoLists().stream().map(ToDoMapper::mapToToDoDto).toList()
        );
    }
    public static UserDto MapToUserDto2(User user) {
        return new UserDto(
                user.getUname(),
                user.getUserName(),
                user.getEmail(),
                "******",
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
