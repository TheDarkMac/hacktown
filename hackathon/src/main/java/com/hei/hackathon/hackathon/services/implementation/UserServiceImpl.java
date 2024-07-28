package com.hei.hackathon.hackathon.services.implementation;

import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.exceptions.ResourceNotFoundException;
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

    @Override
    public UserDto getUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow( () ->
                        new ResourceNotFoundException("User with id " + id + " wasn't found !")
                );
        return UserMapper.MapToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User addedUser = userRepository.save(UserMapper.MapToUser(userDto));
        return UserMapper.MapToUserDto(addedUser);
    }

    @Override
    public UserDto updateUser(long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow( () ->
                        new ResourceNotFoundException("User with id " + id + " wasn't found !")
                );

        user.setUname(userDto.getUname());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(CryptoServiceImpl.encrypts(userDto.getPassword()));

        User updatedUser = userRepository.save(user);

        return UserMapper.MapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(long useId) {
        userRepository.deleteById(useId);
    }
}
