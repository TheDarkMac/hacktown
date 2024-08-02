package com.hei.hackathon.hackathon.services;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;

import java.util.List;

public interface TodoListServices {
    List<ToDoListDto> getAllTodoList();

    ToDoListDto getTodoListById(String toDoId);

    ToDoListDto  createTodoList(ToDoListDto toDo, User user);

    ToDoListDto  updateTodoList(String todoId, ToDoListDto updatedTodoDto);

    void deleteTodoListById(String todoId);
}
