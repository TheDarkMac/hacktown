package com.hei.hackathon.hackathon.mapper;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.entity.ToDoList;

public class ToDoMapper {

    public static ToDoListDto mapToToDoDto(ToDoList toDoList){

        return new ToDoListDto(
                toDoList.getId(),
                toDoList.getName()
        );
    }

    public static ToDoList mapToToDoList(ToDoListDto toDoListDto){
        return new ToDoList(
                toDoListDto.getId(),
                toDoListDto.getName()
        );
    }
}
