package com.hei.hackathon.hackathon.services;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.entity.ToDoList;

import java.util.List;

public interface TodoListServices {
    List<ToDoListDto> getAllTodoList();

    ToDoList getTodoListByUserId(String userId);

    ToDoList createTodoList(ToDoList todoList);

    ToDoList updateTodoList(ToDoList todoList);

    ToDoList deleteTodoListById(String todoListId);
}
