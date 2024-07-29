package com.hei.hackathon.hackathon.mapper;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.ToDoList;
import com.hei.hackathon.hackathon.repository.UserRepository;
import com.hei.hackathon.hackathon.services.UserService;
import com.hei.hackathon.hackathon.services.implementation.UserServiceImpl;

public class ToDoMapper {
    private static UserService userService;
    public static ToDoListDto mapToToDoDto(ToDoList toDoList){

        return new ToDoListDto(
                toDoList.getId(),
                toDoList.getName(),
                toDoList.getUser().getId()
        );
    }

    public static ToDoList mapToToDoList(ToDoListDto toDoListDto){
        UserDto userDto = userService.getUserById(toDoListDto.getUserId());
        return new ToDoList(
                toDoListDto.getId(),
                toDoListDto.getName(),
                UserMapper.MapToUser(userDto)
        );
    }
}
