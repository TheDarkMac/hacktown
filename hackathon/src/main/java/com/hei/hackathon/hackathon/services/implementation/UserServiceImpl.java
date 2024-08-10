package com.hei.hackathon.hackathon.services.implementation;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.exceptions.ResourceNotFoundException;
import com.hei.hackathon.hackathon.exceptions.ResourcesDuplicatedException;
import com.hei.hackathon.hackathon.mapper.UserMapper;
import com.hei.hackathon.hackathon.repository.UserRepository;
import com.hei.hackathon.hackathon.services.UserService;
import lombok.AllArgsConstructor;
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

    @Override
    public UserDto getUserById(String userName) {
        User user = userRepository.findById(userName)
                .orElseThrow( () ->
                        new ResourceNotFoundException("User with id " + userName + " wasn't found !")
                );
        return UserMapper.MapToUserDto2(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if (!checkUserNameUnity(userDto)) {
            throw new ResourcesDuplicatedException("This user is already registered !");
        }
        User addedUser = userRepository.save(UserMapper.MapToUser(userDto));
        return UserMapper.MapToUserDto(addedUser);
    }

    @Override
    public UserDto updateUser(String userName, UserDto userDto) {
        User user = userRepository.findById(userName)
                .orElseThrow( () ->
                        new ResourceNotFoundException("User with id " + userName + " wasn't found !")
                );

        user.setUname(userDto.getUname());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(CryptoServiceImpl.encrypts(userDto.getPassword()));

        User updatedUser = userRepository.save(user);

        return UserMapper.MapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(String userName) {
        userRepository.deleteById(userName);
    }

    @Override
    public boolean checkUserLogin(UserDto userDto) {
        User user = UserMapper.MapToUser(userDto);
        List<User> userList = userRepository.findAll();
        for(User u : userList) {
            if (u.getUserName().equals(user.getUserName())
            && u.getPassword().equals(user.getPassword())
            && u.getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUserNameUnity(UserDto userDto) {
        List<User> userList = userRepository.findAll();
        for(User u : userList) {
            if (u.getUname().equals(userDto.getUname())) {
                return false;
            }
        }
        return true;
    }
}
