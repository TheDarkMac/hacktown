package com.hei.hackathon.hackathon.services;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.entity.ToDoList;

import java.util.List;

public interface TodoListServices {
    List<ToDoListDto> getAllTodoList();

    ToDoListDto getTodoListByUserId(String toDoId);

    String  createTodoList(ToDoListDto toDo);

    String  updateTodoList(String todoId, ToDoListDto todoDto);

    String deleteTodoListById(String todoId);
}
