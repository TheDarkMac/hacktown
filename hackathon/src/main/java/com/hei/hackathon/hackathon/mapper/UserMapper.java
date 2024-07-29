package com.hei.hackathon.hackathon.mapper;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.exceptions.ResourceNotFoundException;
import com.hei.hackathon.hackathon.services.implementation.CryptoServiceImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto MapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUname(),
                user.getUserName(),
                user.getEmail(),
                CryptoServiceImpl.decrypts(user.getPassword()),
                user.getToDoLists().stream().map(ToDoMapper::mapToToDoDto).collect(Collectors.toSet())
        );
    }

    public static User MapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getUname(),
                userDto.getEmail(),
                CryptoServiceImpl.encrypts(userDto.getPassword()),
                userDto.getToDoListDtos().stream().map(ToDoMapper::mapToToDoList).collect(Collectors.toSet())
        );
    }
}
