package com.hei.hackathon.hackathon.services;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import java.util.List;

public interface TodoListServices {
    List<ToDoListDto> getAllTodoList();

    ToDoListDto getTodoListById(String toDoId);

    ToDoListDto  createTodoList(ToDoListDto toDo);

    ToDoListDto  updateTodoList(String todoId, ToDoListDto updatedTodoDto);

    void deleteTodoListById(String todoId);
}
