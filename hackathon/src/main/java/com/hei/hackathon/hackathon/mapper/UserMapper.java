package com.hei.hackathon.hackathon.mapper;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.services.CryptoService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class UserMapper {

    private static CryptoService cryptoService;

    public static UserDto MapToUserDto(User user)
            throws NoSuchPaddingException,
            IllegalBlockSizeException,
            NoSuchAlgorithmException,
            BadPaddingException,
            InvalidKeyException {

        String id = user.getId();
        String userName = user.getUserName();
        String password = cryptoService.decryptPassword(user.getPassword());

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
        byte[] password = cryptoService.encryptPassword(userDto.getPassword());

        return new User(id, userName, password);
    }
}
