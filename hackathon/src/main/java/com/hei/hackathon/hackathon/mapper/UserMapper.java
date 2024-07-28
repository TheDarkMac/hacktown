package com.hei.hackathon.hackathon.mapper;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.services.UserService;
import com.hei.hackathon.hackathon.services.implementation.UserServiceImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class UserMapper {

    private static UserService userService;

    public static UserDto MapToUserDto(User user)
            throws NoSuchPaddingException,
            IllegalBlockSizeException,
            NoSuchAlgorithmException,
            BadPaddingException,
            InvalidKeyException {

        String id = user.getId();
        String userName = user.getUserName();
        String password = userService.decryptPassword(user.getPassword());

        return new UserDto(id, userName, password);
    }

    public static User MapToUser(UserDto userDto)
            throws NoSuchPaddingException,
            IllegalBlockSizeException,
            NoSuchAlgorithmException,
            BadPaddingException,
            InvalidKeyException {

        String id = userDto.getId();
        String userName = userDto.getUserName();
        byte[] password = userService.encryptPassword(userDto.getPassword());

        return new User(id, userName, password);
    }
}
