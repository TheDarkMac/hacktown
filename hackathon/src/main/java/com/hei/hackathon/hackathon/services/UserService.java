package com.hei.hackathon.hackathon.services;

import com.hei.hackathon.hackathon.dto.UserDto;
import java.util.List;

public interface UserService {
     List<UserDto> getAllUsers();

     UserDto getUserById(String userName);

     UserDto createUser(UserDto userDto);

     UserDto updateUser(String userName, UserDto userDto);

     void deleteUser(String userName);

     boolean checkUserLogin(UserDto userDto);
}
