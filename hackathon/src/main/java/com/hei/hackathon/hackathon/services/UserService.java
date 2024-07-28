package com.hei.hackathon.hackathon.services;

import com.hei.hackathon.hackathon.dto.UserDto;
import java.util.List;

public interface UserService {
     List<UserDto> getAllUsers();

     UserDto getUserById(long id);

     UserDto createUser(UserDto userDto);

     UserDto updateUser(long id, UserDto userDto);

     void deleteUser(long userId);
}
