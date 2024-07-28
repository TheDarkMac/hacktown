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

public class UserMapper {
    public static UserDto MapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                CryptoServiceImpl.decrypts(user.getPassword())
        );
    }

    public static User MapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                CryptoServiceImpl.encrypts(userDto.getPassword())
        );
    }
}
