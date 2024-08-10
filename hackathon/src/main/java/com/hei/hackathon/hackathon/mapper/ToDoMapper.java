package com.hei.hackathon.hackathon.mapper;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.ToDoList;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.repository.UserRepository;
import com.hei.hackathon.hackathon.services.UserService;
import com.hei.hackathon.hackathon.services.implementation.UserServiceImpl;
import lombok.AllArgsConstructor;


public class ToDoMapper {

    public static ToDoListDto mapToToDoDto(ToDoList toDoList){
        return new ToDoListDto(
                toDoList.getId(),
                toDoList.getSignature(),
                toDoList.getName(),
                toDoList.getUser().getUserName()
        );
    }

    public static ToDoList mapToToDoList(ToDoListDto toDoListDto){
        return new ToDoList(
                toDoListDto.getId(),
                toDoListDto.getSignature(),
                toDoListDto.getName(),
                null
        );
    }
    public static ToDoList mapToToDoList(ToDoListDto toDoListDto, User user){
        return new ToDoList(
                toDoListDto.getId(),
                toDoListDto.getSignature(),
                toDoListDto.getName(),
                user
        );
    }
}
